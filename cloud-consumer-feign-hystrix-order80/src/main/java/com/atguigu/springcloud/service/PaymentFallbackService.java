package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author shkstart
 * @create 2021-03-01 20:07
 */
@Component
public class PaymentFallbackService implements PaymentHystrix{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService--发生异常--paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService--发生异常--paymentInfo_TimeOut";
    }
}
