package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author shkstart
 * @create 2021-02-26 19:35
 */
@RestController
@Slf4j
public class OrderConsulController {

    private static final String PAYMENT_URL = "http://consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String consumerConsul(){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul",String.class);
    }

}
