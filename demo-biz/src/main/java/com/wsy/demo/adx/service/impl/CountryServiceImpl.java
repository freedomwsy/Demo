/*
 * File Name: ContentServiceImpl
 * Project Name: demo
 * Copyright:Copyright © 1985-2018 Sheldon.Wu Inc.All right reserved.
 */
package com.wsy.demo.adx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsy.demo.adx.dao.CountryMapper;
import com.wsy.demo.adx.model.Country;
import com.wsy.demo.adx.service.CountryService;
import org.springframework.stereotype.Service;

/**
 * ContentServiceImpl
 *
 * @author sheldon.wu
 * @date 2021/1/6 9:58
 * @since 1.0.0
 */
@Service
public class CountryServiceImpl extends ServiceImpl<CountryMapper, Country> implements CountryService {
}
