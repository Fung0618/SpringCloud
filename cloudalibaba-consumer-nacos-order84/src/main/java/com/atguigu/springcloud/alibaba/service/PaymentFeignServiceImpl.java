package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author shkstart
 * @create 2021-03-05 11:06
 */
@Component
public class PaymentFeignServiceImpl implements PaymentFeignService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<Payment>(444,"服务降级处理方式",new Payment(id,"errorSerial444"));
    }
}
