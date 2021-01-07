package com.wsy.demo.common.tool.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SysConstants
 * @Description: 全应用程序的常量
 * @Author sheldon.wu
 * @Date 2020/11/18 10:55
 * @Since v1.0.0
 */
public class SysConstants {

    /**
     * 操作成功
     */
    public static final String MESSAGE_00 = "00";

    /**
     * 操作失败
     */
    public static final String MESSAGE_01 = "01";

    /**
     * 消息MAP集合<br/>
     * ("00", "操作成功");<br/>
     * ("01", "操作失败");<br/>
     */
    public static final Map<String, String> MESSAGE_MAP = new HashMap<String, String>();

      static {
        MESSAGE_MAP.put("00", "操作成功");
        MESSAGE_MAP.put("01", "操作失败");
    }

    /**
     * 获取消息MAP集合，单个值<br/>
     * ("00", "操作成功");<br/>
     * ("01", "操作失败");<br/>
     */
    public static Map<String, String> getMessageUniq(String code) {
        Map<String, String> result = new HashMap<>(SysConstants.INIT_SIZE);
        if (SysConstants.MESSAGE_MAP.containsKey(code)) {
            result.put("code", code);
            result.put("message", MESSAGE_MAP.get(code));
        }
        return result;
    }

    /**
     * 初始化大小
     */
    public static final Integer INIT_SIZE = 16;

}
