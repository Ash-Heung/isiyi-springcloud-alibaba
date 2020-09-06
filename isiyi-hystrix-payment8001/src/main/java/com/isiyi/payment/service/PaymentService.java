package com.isiyi.payment.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {


    /**
     * 正常访问，ok
     * @param id
     * @return
     */
    public String paymentOk(Integer id){
        return "线程池"+Thread.currentThread().getName()+"paymentOk, id: "+id+",haha~";
    }

    /**
     * 正常访问，ok
     * @param id
     * @return
     */
    public String paymentTimeout(Integer id){
        int timeOut = 1;
        try {
            TimeUnit.SECONDS.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池"+Thread.currentThread().getName()+"paymentTimeout, id: "+id+"，耗时："+timeOut;
    }


}
