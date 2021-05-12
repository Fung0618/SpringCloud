package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.AccountDao;
import com.atguigu.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author shkstart
 * @create 2021-03-05 19:53
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------开始账户扣减");
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountDao.decrease(userId,money);
        log.info("-------完成账户扣减");
    }
}
