package com.isiyi.order.controller;

import com.isiyi.common.domain.Payment;
import com.isiyi.common.entity.vo.ResultVO;
import com.isiyi.order.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private PaymentFeignService paymentFeignService;


    @GetMapping("/findPayment/{id}")
    public ResultVO findPayment(@PathVariable("id") Long id){
        ResultVO<Payment> vo = paymentFeignService.findById(id);

        return vo;

    }


}
