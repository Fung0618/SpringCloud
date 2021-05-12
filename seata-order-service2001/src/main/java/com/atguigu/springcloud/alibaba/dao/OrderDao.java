package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author shkstart
 * @create 2021-03-05 14:56
 */
@Mapper
public interface OrderDao {

    public void createOrder(Order order);

    public void updateOrder(@Param("userId") Long userId, @Param("status") Integer status);

}
