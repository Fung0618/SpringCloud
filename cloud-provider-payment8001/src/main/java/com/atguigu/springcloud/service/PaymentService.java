package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author shkstart
 * @create 2021-02-25 15:45
 */

public interface PaymentService {

    public int creat(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
