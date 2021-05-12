package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.Order;
import org.springframework.stereotype.Service;

/**
 * @author shkstart
 * @create 2021-03-05 15:14
 */
public interface OrderService {

    //新建订单
    public void createOrder(Order order);

    //修改订单状态0---->1
    public void updateOrder(Long userId,Integer status);

}
