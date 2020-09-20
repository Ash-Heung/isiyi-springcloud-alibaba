package com.isiyi.sentinel.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.isiyi.common.domain.Payment;
import com.isiyi.common.entity.vo.ResultVO;
import com.isiyi.sentinel.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {


    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public ResultVO byResource()
    {
        return new ResultVO().success(new Payment(2020L,"serial001"));
    }
    public ResultVO handleException(BlockException exception)
    {
        return new ResultVO().error(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

    /**
     * 使用自定义的限流的问题报错。Whitelabel Error Page
     * @return
     */
    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException1"
        )
    public ResultVO byUrl()
    {
        return new ResultVO().success(new Payment(2021L,"serial002"));
    }

}
