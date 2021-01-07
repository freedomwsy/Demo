/*
 * File Name: ContentServiceImpl
 * Project Name: demo
 * Copyright:Copyright © 1985-2018 Sheldon.Wu Inc.All right reserved.
 */
package com.wsy.demo.adx.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsy.demo.adx.dao.ContentMapper;
import com.wsy.demo.adx.dto.ContentDTO;
import com.wsy.demo.adx.model.Content;
import com.wsy.demo.adx.model.Country;
import com.wsy.demo.adx.model.JsonRootBean;
import com.wsy.demo.adx.model.Medias;
import com.wsy.demo.adx.service.ContentService;
import com.wsy.demo.adx.service.CountryService;
import com.wsy.demo.adx.vo.ContentExcel;
import com.wsy.demo.common.base.model.BaseDTO;
import com.wsy.demo.common.utils.EasyExcelUtils;
import com.wsy.demo.common.utils.PagingUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ContentServiceImpl
 *
 * @author sheldon.wu
 * @date 2021/1/6 9:58
 * @since 1.0.0
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements ContentService {

    @Autowired
    private CountryService countryService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(BaseDTO<ContentDTO> dto) {
        ContentDTO contentDTO = dto.getPayload();
        String path = ContentServiceImpl.class.getClassLoader().getResource(contentDTO.getFileName()).getPath();
        String s = readJsonFile(path);
        JSONObject jsonObject = JSON.parseObject(s);
        JsonRootBean jsonRootBean = jsonObject.toJavaObject(JsonRootBean.class);
        List<Content> list = jsonRootBean.getContent();
        list.stream().forEach(content -> {
            this.save(content);
        });
    }

    @Override
    public void exportExcel(BaseDTO<ContentDTO> dto, HttpServletResponse response) {
        ContentDTO contentDTO = dto.getPayload();
        List<Content> list = this.baseMapper.selectList(new LambdaQueryWrapper<>(Content.class).eq(Content::getId, contentDTO.getId()));
        List<ContentExcel> excelList = new ArrayList<>();
        list.stream().forEach(content -> {
            ContentExcel contentExcel = new ContentExcel();
            contentExcel.setMaterialFirstSeen(content.getMaterialFirstSeen());
            contentExcel.setMaterialLastSeen(content.getMaterialLastSeen());
            contentExcel.setMaterialDays(content.getMaterialDays());
            List<Medias> medias = JSON.parseArray(content.getMedias().toString(), Medias.class);
            List<String> mediaList = medias.stream().map(medias1 -> medias1.getMediaName()).collect(Collectors.toList());
            List<String> mList = new ArrayList<>();
            mediaList.stream().forEach(s -> {
                if (s.toLowerCase().contains("facebook") || s.toLowerCase().contains("instagram")) {
                    mList.add("Facebook");
                } else if (s.toLowerCase().contains("admob") || s.toLowerCase().contains("youtube")) {
                    mList.add("Google");
                } else if (s.toLowerCase().contains("unity")) {
                    mList.add("Unity");
                } else {
                    mList.add(s);
                }
            });
            List<String> newList = mList.stream().distinct().collect(Collectors.toList());
            contentExcel.setMediaType(String.join(",", newList));
            contentExcel.setCreativeNum(content.getCreativeNum());
            if (content.getMaterialType() == 1) {
                contentExcel.setMaterialType("图片");
                contentExcel.setPicUrl(content.getPicList().get(0));
            }
            if (content.getMaterialType() == 2) {
                contentExcel.setMaterialType("视频");
                contentExcel.setVideoUrl(content.getVideoList().get(0));
            }
            List<Integer> countryIds = content.getCreative().getCountryId();
            List<String> countryList = countryService.getBaseMapper().selectBatchIds(countryIds).stream().map(Country::getCountryName)
                    .collect(
                            Collectors.toList());
            contentExcel.setCountry(String.join(",", countryList));
            contentExcel.setUsa(content.getCreative().getCountryId().contains(1) ? "是" : "否");
            contentExcel.setJapan(content.getCreative().getCountryId().contains(13) ? "是" : "否");
            contentExcel.setAndroid(content.getMobileTypes().contains(1) ? "是" : "否");
            contentExcel.setIos(content.getMobileTypes().contains(2) ? "是" : "否");
            excelList.add(contentExcel);
        });
        EasyExcelUtils.exportExcel(response, ContentExcel.class, excelList, dto.getLang());
    }

    @Override
    public IPage<Content> pageList(BaseDTO<ContentDTO> dto) {
        ContentDTO contentDTO = dto.getPayload();
        Page<Content> page = PagingUtil.initPage(contentDTO);
        return this.baseMapper.selectPage(page,new LambdaQueryWrapper<>(Content.class));
    }


    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
