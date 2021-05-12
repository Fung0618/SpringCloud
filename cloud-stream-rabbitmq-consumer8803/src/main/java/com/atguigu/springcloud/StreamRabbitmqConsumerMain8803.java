package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author shkstart
 * @create 2021-03-02 21:24
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitmqConsumerMain8803 {

    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitmqConsumerMain8803.class,args);
    }

}
