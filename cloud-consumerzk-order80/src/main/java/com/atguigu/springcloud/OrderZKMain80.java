package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author shkstart
 * @create 2021-02-26 17:32
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain80.class,args);
    }

}
