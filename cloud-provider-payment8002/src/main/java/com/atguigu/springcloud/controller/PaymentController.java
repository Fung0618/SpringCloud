package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author shkstart
 * @create 2021-02-25 17:14
 */
@RestController
@Slf4j //打印日志
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
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

    @GetMapping("/payment/lb")
    public String getPaymentPort(){
        return serverPort;
    }
}
