package com.isiyi.common.entity.vo;

import com.isiyi.common.enums.ResultEnum;
import lombok.Data;

@Data
public class ResultVO<T> {
    /**
     * 操作返回信息
     */
    private String msg;
    /**
     * 操作返回信息代码
     */
    private Integer code;
    /**
     * 返回具体数据
     */
    private T data;

    public ResultVO() {
    }

    public ResultVO success() {
        return this.success(null);
    }

    public ResultVO success(T data) {
        this.setCode(ResultEnum.OK.getCode());
        this.setMsg(ResultEnum.OK.getMessage());
        this.setData(data);
        return this;
    }

    public ResultVO error(ResultEnum rsEnum) {
        return this.error(rsEnum.getCode(), rsEnum.getMessage());
    }

    public ResultVO error(Integer code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }

}
