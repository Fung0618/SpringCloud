package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用于远程调用Storage模块的controller
 * @author shkstart
 * @create 2021-03-05 16:34
 */
@Component
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
