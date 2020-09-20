package com.isiyi.order.controller;

import com.isiyi.common.entity.vo.ResultVO;
import com.isiyi.order.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public ResultVO paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }
}
