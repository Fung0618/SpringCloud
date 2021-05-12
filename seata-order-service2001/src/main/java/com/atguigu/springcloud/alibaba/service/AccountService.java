package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * 用于远程调用Account模块的Controller
 * @author shkstart
 * @create 2021-03-05 16:33
 */
@Component
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money);

}
