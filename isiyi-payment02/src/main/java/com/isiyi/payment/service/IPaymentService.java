package com.isiyi.payment.service;

import com.isiyi.payment.entity.Payment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xpf
 * @since 2020-08-04
 */
public interface IPaymentService extends IService<Payment> {

    Payment findById(Long id);


}
