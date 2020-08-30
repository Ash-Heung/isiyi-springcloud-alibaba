package com.isiyi.order.service;


import com.isiyi.common.domain.Payment;
import com.isiyi.common.entity.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "ISIYI-PAYMENT")
public interface PaymentFeignService {

    @GetMapping("/payment/findOne/{id}")
    ResultVO<Payment> findById(@PathVariable("id") Long id);

}
