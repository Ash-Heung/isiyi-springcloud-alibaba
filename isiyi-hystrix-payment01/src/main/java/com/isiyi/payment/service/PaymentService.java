package com.isiyi.payment.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+",paymentInfo_OK";
    }

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_Timeout(Integer id){
        return "线程池："+Thread.currentThread().getName()+",paymentInfo_Timeout";
    }

}
