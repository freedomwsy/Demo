/*
 * File Name: AdxController
 * Project Name: demo
 * Copyright:Copyright © 1985-2018 Sheldon.Wu Inc.All right reserved.
 */
package com.wsy.demo.adx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wsy.demo.adx.dto.ContentDTO;
import com.wsy.demo.adx.model.Content;
import com.wsy.demo.adx.service.ContentService;
import com.wsy.demo.common.base.model.BaseDTO;
import com.wsy.demo.common.base.vo.Result;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AdxController
 *
 * @author sheldon.wu
 * @date 2021/1/6 11:59
 * @since 1.0.0
 */
@RestController
@RequestMapping("/adx")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @PostMapping("save")
    public Result save(@RequestBody BaseDTO<ContentDTO> dto) {

        contentService.save(dto);

        return Result.getSuccess(dto.getLang());
    }

    @PostMapping("exportExcel")
    public void exportExcel(@RequestBody BaseDTO<ContentDTO> dto, HttpServletResponse response) {
        contentService.exportExcel(dto, response);
    }

    @PostMapping("pageList")
    public Result pageList(@RequestBody BaseDTO<ContentDTO> dto) {
        IPage<Content> result = contentService.pageList(dto);
        return Result.getSuccess(result, dto.getLang());
    }
}
