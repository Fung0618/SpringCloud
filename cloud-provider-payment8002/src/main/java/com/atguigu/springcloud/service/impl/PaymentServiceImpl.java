package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shkstart
 * @create 2021-02-25 15:47
 */
@Service
public class PaymentServiceImpl implements PaymentService{

        @Resource //根据类型注入
//    @Autowired IDEA会爆红，需要讲Error设置成Warning
    private PaymentDao paymentDao;

    public int creat(Payment payment) {
        return paymentDao.creat(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
