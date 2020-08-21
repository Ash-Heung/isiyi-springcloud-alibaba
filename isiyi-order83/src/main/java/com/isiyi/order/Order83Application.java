package com.isiyi.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Order83Application {

    public static void main(String[] args) {
        SpringApplication.run(Order83Application.class, args);
    }

}
