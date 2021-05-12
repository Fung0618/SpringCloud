package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


/**
 * @author shkstart
 * @create 2021-03-04 13:54
 */
@RestController
@Slf4j
public class SentinelController {


    @GetMapping("/testA")
    public String testA(){
//        this.sendMessage();
        log.info(Thread.currentThread().getName() );
            return  "---testA";
    }


    @GetMapping("/testB")
    public String testB(){
//        this.sendMessage();
        log.info(Thread.currentThread().getName() );
        return  "-----testB";
    }
//
//    @SentinelResource(value = "sendMessage")
//    public String sendMessage(){
//        return "----sendMessage";
//    }


    @GetMapping("/testD")
    public String testD()
    {
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");

        return "------testD";
    }

    @GetMapping("/testE")
    public String testE()
    {
        log.info("testE 测试异常数");
        int age = 10/0;
        return "------testE 测试异常数";
    }

    @GetMapping("/testhotkey")
    @SentinelResource(value = "testhotkey")
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2){
        return "---------testhotkey";
    }

    public String fallback_hotkey(String p1, String p2, BlockException ex){
        return "错啦错啦/(ㄒoㄒ)/~~";
    }


//    @SentinelResource("sendMessage")
//    private String sendMessage(){
//        return "sendMessage";
//    }

}
