package com.isiyi.common.exception;


import com.isiyi.common.entity.vo.ResultVO;
import com.isiyi.common.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @ClassName : ApiExceptionHandler
 * @Description : 异常捕获
 * @Author : xpf
 * @Date: 2020-03-12 17:15
 */
@Slf4j
@Component
@RestControllerAdvice
public class MyExceptionHandler {

    /**
     * 异常捕获
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    public ResultVO apiExceptionHandler(MyException e) {
        // log.error("【请求失败】{}\n\r", e.getStackTrace());
        e.printStackTrace();
        MyException exception = (MyException) e;

        return new ResultVO().error(exception.getCode(), exception.getMessage());
    }

    /**
     * 校验参数的异常
     * @param exception
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        StringBuilder errorMsg = new StringBuilder() ;

        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            fieldErrors.forEach(error -> {
                System.out.println("field" + error.getField() + ", msg:" + error.getDefaultMessage());
                errorMsg.append(error.getDefaultMessage()).append("!");
            });
        }
        return new ResultVO().error(ResultEnum.PARAM_ERROR.getCode(), errorMsg.toString());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResultVO MissingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e) {
        return new ResultVO().error(ResultEnum.PARAM_ERROR);
    }

    /**
     * Apache common utils Validate校验参数的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResultVO IllegalArgumentException(IllegalArgumentException e) {
        return new ResultVO().error(ResultEnum.PARAM_ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultVO ExceptionHandler(Exception e) {
        e.printStackTrace();
        return new ResultVO().error(ResultEnum.UNKNOWN_ERR);
    }

}
