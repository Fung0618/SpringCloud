package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author shkstart
 * @create 2021-03-04 13:52
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceMain8401 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceMain8401.class,args);
    }



}
