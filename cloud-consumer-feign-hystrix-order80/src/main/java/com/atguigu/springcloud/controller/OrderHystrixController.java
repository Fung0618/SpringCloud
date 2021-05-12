package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrix;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shkstart
 * @create 2021-03-01 17:03
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_timeout_fallback_method")
public class OrderHystrixController {

    @Resource
    private PaymentHystrix paymentHystrix;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
//    @HystrixCommand
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHystrix.paymentInfo_OK(id);
        log.info("*******result:"+result);
        return result;
    }


    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")  //3秒钟以内就是正常的业务逻辑
//    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = paymentHystrix.paymentInfo_TimeOut(id);
        return result;
    }

    //兜底方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }

    public String payment_timeout_fallback_method(){
        return "Global异常处理中，请稍后再试";
    }

}
