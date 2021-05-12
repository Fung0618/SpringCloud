package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-02-26 22:23
 */
public interface LoadBalancer {

    //获取微服务实例方法
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
