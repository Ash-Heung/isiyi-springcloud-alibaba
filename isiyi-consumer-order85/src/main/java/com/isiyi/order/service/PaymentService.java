package com.isiyi.order.service;

import com.isiyi.common.entity.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "isiyi-payment-provider")
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    ResultVO paymentSQL(@PathVariable("id") Long id);

}
