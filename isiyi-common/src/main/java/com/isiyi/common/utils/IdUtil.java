package com.isiyi.common.utils;

import java.util.UUID;

/**
 * @ClassName : IdUtil
 * @Description : id字符串生成
 * @Author : xpf
 * @Date: 2020-03-03 14:44
 */
public class IdUtil {

    /**
     * 生成32位uuid字符串
     * @Description:
     * @Author: xpf
     * @Date: 2020/3/3 14:45
     **/
    public static String genUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}
