/*
 * File Name: StoreInfo
 * Project Name: demo
 * Copyright:Copyright © 1985-2018 Sheldon.Wu Inc.All right reserved.
 */
package com.wsy.demo.adx.model;

import java.util.List;
import lombok.Data;

/**
 * StoreInfo
 *
 * @author sheldon.wu
 * @date 2021/1/6 9:46
 * @since 1.0.0
 */
@Data
public class StoreInfo {

    private String appId;
    private String productName;
    private List<String> typeList;
    private String publisherId;
    private String publisherAccountId;
    private String logo;
    private String lang;
}
