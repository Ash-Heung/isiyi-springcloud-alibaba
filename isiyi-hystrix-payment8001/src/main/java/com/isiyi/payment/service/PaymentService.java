package com.isiyi.payment.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {


    public String paymentOk(Integer id){
        return "线程池"+Thread.currentThread().getName()+"paymentOk, id: "+id+",haha~";
    }


}
