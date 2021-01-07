package com.wsy.demo.common.base.model;


import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Transient;

/**
 * @ClassName BaseDTO
 * @Description: DTO基类
 * @Author sheldon.wu
 * @Date 2020/11/25 15:29
 * @Since v1.0.0
 */
@Data
public class BaseDTO<T> implements Serializable {

    /**
     * 语言
     */
    @Transient
    private String lang;

    /**
     * 参数负载
     */
    private T payload;

    /**
     * 企业id
     */
    private String companyId;

    /**
     * 企业code
     */
    private String companyCode;


}
