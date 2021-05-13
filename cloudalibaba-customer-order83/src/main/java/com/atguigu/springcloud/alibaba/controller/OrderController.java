package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author shkstart
 * @create 2021-03-03 12:07
 */
@RestController
public class OrderController {

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentNacos(@PathVariable("id") Integer id){
        return restTemplate.getForObject(serverUrl + "/payment/nacos/" + id,String.class);
    }

    @GetMapping(value = "/testdev")
    public String testDev(){
        System.out.println("分支进行一个修改");
        return "dev";
    }

    @GetMapping(value = "/testdev2")
    public String testDev2(){
        System.out.println("分支进行第一个修改");
        System.out.println("dev修改");
        System.out.println("master修改");
        System.out.println("dev修改");
        return "dev2";
    }

    @GetMapping(value = "/test02")
    public String test01(){
        return "helloworld";
    }

}
