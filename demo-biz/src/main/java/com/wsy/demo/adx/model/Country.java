/*
 * File Name: Country
 * Project Name: demo
 * Copyright:Copyright © 1985-2018 Sheldon.Wu Inc.All right reserved.
 */
package com.wsy.demo.adx.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * Country
 *
 * @author sheldon.wu
 * @date 2021/1/6 12:42
 * @since 1.0.0
 */
@Data
@TableName(value = "country")
public class Country extends Model<Country> {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer countryId;

    @TableField
    private String countryName;

    @TableField
    private String countryLogo;

    @TableField
    private Integer materialNum;

    @TableField
    private Double ratio;

}
