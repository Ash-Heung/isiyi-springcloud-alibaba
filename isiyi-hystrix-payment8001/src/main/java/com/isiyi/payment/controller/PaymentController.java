package com.isiyi.payment.controller;

import com.isiyi.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private  String serverPort;


    @RequestMapping("payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        String res = paymentService.paymentOk(id);
        return res;
    }


    /**
     * 并发请求，耗时的服务时，其他服务也会受影响
     * @param id
     * @return
     */
    @RequestMapping("payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id){
        String res = paymentService.paymentTimeout(id);
        return res;
    }

    //===服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*******result:"+result);
        return result;
    }

}
