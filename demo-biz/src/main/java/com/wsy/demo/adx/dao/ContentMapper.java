/*
 * File Name: ContentMapper
 * Project Name: demo
 * Copyright:Copyright © 1985-2018 Sheldon.Wu Inc.All right reserved.
 */
package com.wsy.demo.adx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wsy.demo.adx.dto.ContentDTO;
import com.wsy.demo.adx.model.Content;
import org.apache.ibatis.annotations.Param;

/**
 * ContentMapper
 *
 * @author sheldon.wu
 * @date 2021/1/6 9:59
 * @since 1.0.0
 */
public interface ContentMapper extends BaseMapper<Content> {

}
