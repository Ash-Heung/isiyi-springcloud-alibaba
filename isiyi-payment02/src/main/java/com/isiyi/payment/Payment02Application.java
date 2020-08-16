package com.isiyi.payment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;


@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.isiyi.*.config", "com.isiyi.payment"})
public class Payment02Application {

    public static void main(String[] args) {
        SpringApplication.run(Payment02Application.class, args);
    }

}
