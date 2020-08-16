﻿package com.isiyi.payment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixApplication.class, args);
    }

}
