package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author shkstart
 * @create 2021-02-25 20:59
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancer loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String getServicePort(){
        ServiceInstance serviceInstance = loadBalancer.instances(discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE"));
        URI uri = serviceInstance.getUri();
        System.out.println("被选中微服务的uri为---->" + uri);
        return restTemplate.getForObject(uri + "/payment/lb",String.class);
    }


//    ==========================采用getForEntity和postForEntity===============
    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult getPaymentById2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            log.info(entity.getStatusCodeValue() + "\t" + entity.getHeaders());
            return entity.getBody();
        }else {
            return new CommonResult(444,"查询失败");
        }
    }

    @GetMapping("/consumer/payment/postEntity")
    public CommonResult create2(Payment payment){
        return restTemplate.postForEntity(PAYMENT_URL + "/payment/create",payment,CommonResult.class).getBody();
    }

    @GetMapping("/consumer/payment/zikpin")
    public String paymentZipkin(){
        return restTemplate.getForObject("http://localhost:8001/payment/zipkin",String.class);
    }


}
