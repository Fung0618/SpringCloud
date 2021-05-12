package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author shkstart
 * @create 2021-03-05 19:54
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId")Long userId, @RequestParam("money")BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResult(200,"账户扣减成功");
    }

}
