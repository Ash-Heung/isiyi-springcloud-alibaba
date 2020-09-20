package com.isiyi.sentinel.myhandler;

import com.isiyi.common.entity.vo.ResultVO;
import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {

    public static ResultVO handleException1(BlockException blockedException){
        return new ResultVO().error(4444, "自定义全局消息返回---处理方法一");
    }

    public static ResultVO handleException2(BlockException blockedException){
        return new ResultVO().error(4444, "自定义全局消息返回---处理方法二");
    }

}
