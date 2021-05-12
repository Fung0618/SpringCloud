package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.alibaba.service.CustomerBlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shkstart
 * @create 2021-03-04 22:27
 */
@RestController
public class RateLimitController
{
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandlerClass = CustomerBlockException.class,
                        blockHandler = "cutomerBlockException1")
    public CommonResult byResource()
    {
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }
//    public CommonResult handleException(BlockException exception)
//    {
//        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
//    }

}
