package com.isiyi.common.enums;

import lombok.Getter;

@Getter
public enum  ResultEnum {

    //结果code和信息
    OK(200, "成功返回"),
    CHECK_ERR(100, "无权限"),
    PERMISSION_INVALID(101, "权限失效，请联系管理员"),
    UPLOAD_FILE_ERR(300, "上传文件出错"),
    PARAM_ERROR(301, "参数错误"),
    UNKNOWN_ERR(999, "未知错误");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
