/*
 * File Name: JsonRootBean
 * Project Name: demo
 * Copyright:Copyright © 1985-2018 Sheldon.Wu Inc.All right reserved.
 */
package com.wsy.demo.adx.model;

import java.util.List;
import lombok.Data;

/**
 * JsonRootBean
 *
 * @author sheldon.wu
 * @date 2021/1/6 9:43
 * @since 1.0.0
 */
@Data
public class JsonRootBean {

    private int statusCode;
    private String msg;
    private Page page;
    private List<Content> content;
}
