package com.wsy.demo.common.utils;


import com.wsy.demo.common.base.model.MessageDTO;
import com.wsy.demo.common.tool.exception.BusinessException;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.lang.Nullable;

/**
 * ResultUtil
 *
 * @author sheldon.wu
 * @date 2020/11/30 14:18
 * @since 1.0.0
 */
public class ResultUtil {

    public ResultUtil() {
    }

    ;

    /**
     * 抛出异常信息
     * @param code
     * @param lang
     */
    public static void handldErrorInfo(String code, String lang) {
        throw new BusinessException(code, lang);
    }

    /**
     * 抛出异常信息 - 断言非null
     * @param object
     * @param code
     * @param lang
     */
    public static void handldNullError(@Nullable Object object, String code, String lang) {
        if (object == null) {
            throw new BusinessException(code, lang);
        }
    }

    /**
     * 抛出异常信息 - 断言非null
     * @param object
     * @param code
     * @param lang
     */
    public static void handldNoNullError(@Nullable Object object, String code, String lang) {
        if (object != null) {
            throw new BusinessException(code, lang);
        }
    }

    /**
     * 抛出异常信息 - 断言字符串 非空
     * @param object
     * @param code
     * @param lang
     */
    public static void handldBlankError(@Nullable String object, String code, String lang) {
        if (StringUtils.isBlank(object)) {
            throw new BusinessException(code, lang);
        }
    }

    /**
     * 抛出异常信息 - 断言对象存在
     * @param object
     * @param code
     * @param lang
     */
    public static void handleExistsError(@Nullable Object object, String code, String lang) {
        if (object != null) {
            throw new BusinessException(code, lang);
        }
    }

    public static List getParamsAsArrayObjByKey(MessageDTO message, String key) {
        if (null == message) {
            return null;
        } else {
            Map<String, Object> payload = message.getPayload();
            if (payload == null) {
                return null;
            } else {
                Map<String, Object> params = (Map) payload.get("params");
                if (null == params) {
                    return null;
                } else {
                    Object value = params.get(key);
                    return null == value ? null : (List) value;
                }
            }
        }
    }

}
