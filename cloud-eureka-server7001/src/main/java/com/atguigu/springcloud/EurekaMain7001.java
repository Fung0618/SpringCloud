package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author shkstart
 * @create 2021-02-25 23:35
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaServer //表示本主SpringbootApplication类管辖的模块就是属于Eureka服务注册中心
public class EurekaMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
