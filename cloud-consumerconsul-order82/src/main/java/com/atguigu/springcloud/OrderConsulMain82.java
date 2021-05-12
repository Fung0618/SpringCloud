package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author shkstart
 * @create 2021-02-26 19:33
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain82 {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain82.class,args);
    }

}
