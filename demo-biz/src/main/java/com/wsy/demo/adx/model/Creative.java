/*
 * File Name: Creative
 * Project Name: demo
 * Copyright:Copyright © 1985-2018 Sheldon.Wu Inc.All right reserved.
 */
package com.wsy.demo.adx.model;

import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * Creative
 *
 * @author sheldon.wu
 * @date 2021/1/6 9:45
 * @since 1.0.0
 */
@Data
public class Creative {

    private long id;
    private int mobileType;
    private int mediaId;
    private int positionId;
    private Date firstSeen;
    private Date lastSeen;
    private List<String> dates;
    private int adType;
    private int materialType;
    private long materialId;
    private String title1;
    private String title1Zh;
    private long title1Id;
    private String title2;
    private String title2Zh;
    private long title2Id;
    private String targetUrl;
    private String downloadUrl;
    private StoreInfo storeInfo;
    private int productId;
    private String productName;
    private String icon;
    private int storeType;
    private List<Integer> productType;
    private int publisherId;
    private String publisherName;
    private List<Integer> countryId;
    private int num;
    private int days;
    private String lang;
}
