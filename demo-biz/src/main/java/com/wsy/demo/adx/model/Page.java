/*
 * File Name: Page
 * Project Name: demo
 * Copyright:Copyright © 1985-2018 Sheldon.Wu Inc.All right reserved.
 */
package com.wsy.demo.adx.model;

import lombok.Data;

/**
 * Page
 *
 * @author sheldon.wu
 * @date 2021/1/6 9:43
 * @since 1.0.0
 */
@Data
public class Page {

    private int pageId;
    private int pageSize;
    private int totalRecords;
    private int totalPage;
}
