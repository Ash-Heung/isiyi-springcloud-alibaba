package com.isiyi.order.service.impl;

import com.isiyi.common.entity.vo.ResultVO;
import com.isiyi.order.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public ResultVO paymentSQL(Long id) {
        return new ResultVO().error(5555, "服务降级返回,---PaymentFallbackService");
    }
}
