/*
 * File Name: Data
 * Project Name: demo
 * Copyright:Copyright © 1985-2018 Sheldon.Wu Inc.All right reserved.
 */
package com.wsy.demo.adx.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * Data
 *
 * @author sheldon.wu
 * @date 2021/1/6 9:17
 * @since 1.0.0
 */
@Data
@TableName(value = "content",autoResultMap = true)
public class Content extends Model<Content> {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    @TableField(typeHandler = FastjsonTypeHandler.class)
    private List<Integer> mediaIds;

    @TableField(typeHandler = FastjsonTypeHandler.class)
    private List<com.wsy.demo.adx.model.Medias> medias;

    @TableField
    private Integer materialType;

    @TableField
    private Integer materialWidth;

    @TableField
    private Integer materialHigh;

    @TableField
    private Date materialFirstSeen;

    @TableField
    private Date materialLastSeen;

    @TableField
    private Integer materialDays;

    @TableField
    private Integer materialNum;

    @TableField(typeHandler = FastjsonTypeHandler.class)
    private List<Integer> mobileTypes;

    @TableField
    private Integer creativeNum;

    @TableField
    private Integer productNum;

    @TableField
    private Integer creativeMaxDays;

    @TableField
    private String playNum;

    @TableField
    private String likeNum;

    @TableField
    private String commentNum;

    @TableField
    private String forwardNum;

    @TableField(typeHandler = FastjsonTypeHandler.class)
    private List<String> picList;

    @TableField(typeHandler = FastjsonTypeHandler.class)
    private List<String> videoList;

    @TableField
    private String playableAdUrl;

    @TableField(typeHandler = FastjsonTypeHandler.class)
    private com.wsy.demo.adx.model.Creative creative;

    @TableField
    private Integer isWatch;

    @TableField
    private String mediaLikeNumDtoList;

    @TableField
    private String mediaPlayNumDtoList;

    @TableField
    private String mediaCommentNumDtoList;

    @TableField
    private String mediaForwardNumDtoList;

    @TableField
    private String collectLabel;

    @TableField
    private String collectTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
