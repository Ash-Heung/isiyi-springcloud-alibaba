package com.isiyi.payment.service.impl;

import com.isiyi.payment.entity.Payment;
import com.isiyi.payment.mapper.PaymentMapper;
import com.isiyi.payment.service.IPaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xpf
 * @since 2020-08-04
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements IPaymentService {


    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Payment findById(Long id) {
        return paymentMapper.selectById(id);
    }
}
