package com.atguigu.springcloud.alibaba.service;

import java.math.BigDecimal;

/**
 * @author shkstart
 * @create 2021-03-05 19:53
 */
public interface AccountService {

    public void decrease(Long userId, BigDecimal money);

}
