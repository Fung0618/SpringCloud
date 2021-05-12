package com.atguigu.springcloud.alibaba.service;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @author shkstart
 * @create 2021-03-04 22:52
 */
public class CustomerBlockException {

    public static CommonResult cutomerBlockException1(BlockException ex1){
        return new CommonResult(2020,"客户自定义降级处理异常1-----cutomerBlockException1");
    }
    public static CommonResult cutomerBlockException2(BlockException ex2){
        return new CommonResult(2020,"客户自定义降级处理异常2-----cutomerBlockException2");
    }

}
