package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Line;
import javax.xml.ws.Service;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author shkstart
 * @create 2021-02-25 17:14
 */
@RestController
@Slf4j //打印日志
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}") //@value注解可以读取配置文件内的信息
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.creat(payment);
        log.info("**************插入结果**********" + result); //再后台打印日志
        if(result > 0){
            return new CommonResult(200,"插入数据库成功" + serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("*************查询结果**********" + paymentById);

        if (paymentById != null){
            return new CommonResult(200,"查询数据库成功" + serverPort,paymentById);
        }else {
            return new CommonResult(444,"没有对应ID" + id + "的查询结果",null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discoveryClient(){
        List<String> services = discoveryClient.getServices();
        for (String service : services){
            log.info("***********service:" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance : instances){
            log.info(instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentPort(){
        return serverPort;
    }


    //测试OpenFeign超时控制
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return serverPort + "hahahhaahhaahah";
    }

}
