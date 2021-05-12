package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shkstart
 * @create 2021-03-01 15:41
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_Ok(@PathVariable("id") Integer id){
        return paymentHystrixService.PaymentInfo_Ok(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String PaymentInfo_Timeout(@PathVariable("id") Integer id){
        return paymentHystrixService.PaymentInfo_Timeout(id);
    }

    //========服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentCircuitBreaker(id);
        log.info("*******result:"+result);
        return result;
    }

}
