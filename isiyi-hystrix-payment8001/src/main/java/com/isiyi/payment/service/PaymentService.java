package com.isiyi.payment.service;

import com.isiyi.common.utils.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
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
    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler",
            commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentTimeout(Integer id){
//        int timeOut = 5;
//        try {
//            TimeUnit.SECONDS.sleep(timeOut);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int i = 5 / 0;


        return "线程池"+Thread.currentThread().getName()+"paymentTimeout, id: "+id+"，耗时：";
    }

    public String paymentTimeoutHandler(Integer id){
        return "线程池"+Thread.currentThread().getName()+"paymentTimeoutHandler, 8001系统出错,id: "+id;
    }

    /*************************************************************************************/

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = UUID.randomUUID().toString();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }

}
