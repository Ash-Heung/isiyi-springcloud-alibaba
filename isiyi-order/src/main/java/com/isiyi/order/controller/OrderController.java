package com.isiyi.order.controller;

import com.isiyi.common.entity.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
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

    @Resource
    private RestTemplate restTemplate;

    private final static String PAYMENT_SERVER = "http://ISIYI-PAYMENT";


    @GetMapping("/findPayment/{id}")
    public ResultVO findPayment(@PathVariable("id") Long id){
        ResponseEntity<ResultVO> forEntity = restTemplate.getForEntity(PAYMENT_SERVER+"/payment/findOne/" + id, ResultVO.class);

        ResultVO body = forEntity.getBody();

        return body;

    }


}
