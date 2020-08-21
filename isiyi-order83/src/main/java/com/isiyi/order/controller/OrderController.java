package com.isiyi.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-user-service}")
    private String serverUrl;


    @GetMapping(value = "/payment/nacos/{id}")
    public String payment(@PathVariable("id") Integer id)
    {
        return restTemplate.getForObject(serverUrl+"/payment/nacos/"+ id, String.class);
    }

}
