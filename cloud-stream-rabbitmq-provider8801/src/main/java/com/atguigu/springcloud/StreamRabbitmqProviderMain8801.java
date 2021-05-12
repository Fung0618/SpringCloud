package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author shkstart
 * @create 2021-03-02 20:22
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitmqProviderMain8801 {

    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitmqProviderMain8801.class,args);
    }

}
