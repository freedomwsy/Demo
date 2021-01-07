/*
 * File Name: ContentDTO
 * Project Name: demo
 * Copyright:Copyright © 1985-2018 Sheldon.Wu Inc.All right reserved.
 */
package com.wsy.demo.adx.dto;

import com.wsy.demo.common.base.vo.BaseQueryVO;
import java.io.Serializable;
import lombok.Data;

/**
 * ContentDTO
 *
 * @author sheldon.wu
 * @date 2021/1/6 12:28
 * @since 1.0.0
 */
@Data
public class ContentDTO extends BaseQueryVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fileName;

}
