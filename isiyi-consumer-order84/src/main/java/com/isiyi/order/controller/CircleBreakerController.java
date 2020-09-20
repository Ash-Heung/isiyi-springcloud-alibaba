package com.isiyi.order.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.isiyi.common.domain.Payment;
import com.isiyi.common.entity.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://isiyi-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    /**
     * 测试熔断策略
     * fallback： 只支持异常处理
     * blockHandler: 只支持sentinel的配置规则
     * 同时配置fallback和blockHandler可以即处理java异常也可以处理sentinel规则错误
     * @param id
     * @return
     */
    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback", fallback = "fallbackHandler")
 //   @SentinelResource(value = "fallback",fallback = "fallbackHandler", blockHandler = "blockHandler")
    public ResultVO<Payment> fallback(@PathVariable Long id)
    {
        ResultVO<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id,ResultVO.class,id);

        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }

    public ResultVO fallbackHandler(@PathVariable Long id, Throwable throwable){
        log.error("程序出现问题，问题是：{}", throwable.getMessage());
        return new ResultVO().error(9999, "这是一个fallback方法");

    }

    public ResultVO blockHandler(@PathVariable Long id, BlockException blockException){
        log.error("程序出现问题，问题是：{}", blockException);
        return new ResultVO().error(9999, "这是一个blockHandler方法");

    }

}
