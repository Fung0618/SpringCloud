package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.OrderDao;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.AccountService;
import com.atguigu.springcloud.alibaba.service.OrderService;
import com.atguigu.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author shkstart
 * @create 2021-03-05 15:16
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void createOrder(Order order) {
        log.info("------->开始新建订单");
        orderDao.createOrder(order);
        log.info("------->订单微服务开始调用库存微服务扣减库存");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------->订单微服务开始调用库存微服务扣减库存end");
        log.info("------->订单微服务开始调用账户微服务扣减余额");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------->订单微服务开始调用账户微服务扣减余额end");
        log.info("------->开始修改订单状态");
        orderDao.updateOrder(order.getUserId(),0);
        log.info("------->结束修改订单状态");
        log.info("------->下订单结束");

    }

    @Override
    public void updateOrder(Long userId, Integer status) {
        orderDao.updateOrder(userId,status);
    }
}
