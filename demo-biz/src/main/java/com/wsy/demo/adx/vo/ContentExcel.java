/*
 * File Name: ContentVO
 * Project Name: demo
 * Copyright:Copyright © 1985-2018 Sheldon.Wu Inc.All right reserved.
 */
package com.wsy.demo.adx.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * ContentVO
 *
 * @author sheldon.wu
 * @date 2021/1/6 13:54
 * @since 1.0.0
 */
@Data
public class ContentExcel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "首次展示时间", index = 0)
    private Date materialFirstSeen;

    @ExcelProperty(value = "末次展示时间", index = 1)
    private Date materialLastSeen;

    @ExcelProperty(value = "投放时长（天数）", index = 2)
    private Integer materialDays;

    @ExcelProperty(value = "投放渠道", index = 3)
    private String mediaType;

    @ExcelProperty(value = "关联计划数", index = 4)
    private Integer creativeNum;

    @ExcelProperty(value = "素材类型", index = 5)
    private String materialType;

    @ExcelProperty(value = "视频url", index = 6)
    private String videoUrl;

    @ExcelProperty(value = "图片url", index = 7)
    private String picUrl;

    @ExcelProperty(value = "国家/地区", index = 8)
    private String country;

    @ExcelProperty(value = "是否美国", index = 9)
    private String usa;

    @ExcelProperty(value = "是否日本", index = 10)
    private String japan;

    @ExcelProperty(value = "是否安卓", index = 11)
    private String android;

    @ExcelProperty(value = "是否ios", index = 12)
    private String ios;
}
