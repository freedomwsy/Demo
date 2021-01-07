/*
 * File Name: ContentService
 * Project Name: demo
 * Copyright:Copyright © 1985-2018 Sheldon.Wu Inc.All right reserved.
 */
package com.wsy.demo.adx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wsy.demo.adx.dto.ContentDTO;
import com.wsy.demo.adx.model.Content;
import com.wsy.demo.common.base.model.BaseDTO;
import javax.servlet.http.HttpServletResponse;

/**
 * ContentService
 *
 * @author sheldon.wu
 * @date 2021/1/6 9:55
 * @since 1.0.0
 */
public interface ContentService extends IService<Content> {

    /**
     * save
     *
     * @param dto
     * @return void
     * @throws
     * @author sheldon.wu
     * @date 2021/1/6 18:22
     * @since 1.0.0
     */
    void save(BaseDTO<ContentDTO> dto);

    /**
     * exportExcel
     *
     * @param dto
     * @param response
     * @return void
     * @throws
     * @author sheldon.wu
     * @date 2021/1/6 18:23
     * @since 1.0.0
     */
    void exportExcel(BaseDTO<ContentDTO> dto, HttpServletResponse response);

    /**
     * pageList
     *
 * @param dto
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.wsy.demo.adx.model.Content>
     * @throws
     * @author sheldon.wu
     * @date 2021/1/6 18:24
     * @since 1.0.0
     */
    IPage<Content> pageList(BaseDTO<ContentDTO> dto);

}
