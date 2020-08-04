package com.isiyi.common.exception;

import com.isiyi.common.enums.ResultEnum;
import lombok.Data;

@Data
public class MyException extends RuntimeException {
    private static final long serialVersionUID = -264642953362377330L;
    private Integer code;

    public MyException(ResultEnum rs) {
        super(rs.getMessage());
        this.code = rs.getCode();
    }


    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    @Override
    public String toString() {
        return "ApiException{code=" + this.code + "，message=" + getMessage() + "}";
    }

}
