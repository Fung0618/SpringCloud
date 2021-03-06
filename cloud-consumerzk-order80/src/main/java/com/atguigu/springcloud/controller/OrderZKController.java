package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author shkstart
 * @create 2021-02-26 17:36
 */
@RestController
@Slf4j
public class OrderZKController {

    private static final String PAYMENT_URL = "http://cloud-provider-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String consumerZK(){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk",String.class);
    }

}
