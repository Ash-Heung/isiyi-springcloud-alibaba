package com.isiyi.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @ClassName : EncryptUtil
 * @Description : 加密工具类
 * @Author : xpf
 * @Date: 2020-03-13 17:23
 */
public class EncryptUtil {

    /**
     * MD5加密
     *
     * @param text
     * @return java.lang.String
     * @Description:
     * @Author: xpf
     * @Date: 2020/3/13 17:29
     **/
    public static String md5Encrypt(String text) {
        String md5Salt = IdUtil.genUUID();
        String str = "" + md5Salt.charAt(0) + md5Salt.charAt(2) + text + md5Salt.charAt(5) + md5Salt.charAt(4);
        return md5(str);
    }

    private static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }
}
