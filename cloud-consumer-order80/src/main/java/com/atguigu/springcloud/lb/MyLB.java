package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shkstart
 * @create 2021-02-28 21:45
 */
@Component
public class MyLB implements LoadBalancer {

    //用来得到当前的
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >=  Integer.MAX_VALUE ? 0 : current + 1;
        }while (!atomicInteger.compareAndSet(current,next));
        System.out.println("第" + next + "次访问");
            return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
