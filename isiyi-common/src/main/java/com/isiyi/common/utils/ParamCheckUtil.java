package com.isiyi.common.utils;


import com.isiyi.common.enums.ResultEnum;
import com.isiyi.common.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * 参数处理工具类
 * @author xpf
 * @date 2018/5/22
 */
@Slf4j
public class ParamCheckUtil {

    public static void checkRequestParams(BindingResult bindinResult) {
        if (bindinResult.hasErrors()) {
            StringBuilder message = new StringBuilder();
            List<FieldError> fieldErrors = bindinResult.getFieldErrors();
            for (FieldError err :
                    fieldErrors) {
                message.append(err.getDefaultMessage())
                        .append(";");
            }
            throw new MyException(ResultEnum.OK.getCode(), message.toString());
        }
    }
}
