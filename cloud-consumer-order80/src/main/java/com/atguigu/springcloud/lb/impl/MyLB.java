package com.atguigu.springcloud.lb.impl;

import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wxj
 * @version 1.0.0
 * @ClassName MyLB.java
 * @Description TODO
 * @createTime 2022年05月21日 13:14:00
 */
@Component
@Slf4j
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);


    public final  int getAndIncrement(){
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!atomicInteger.compareAndSet(current,next));
        log.info("--------next:{}",next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();

        ServiceInstance serviceInstance = serviceInstances.get(index);
        return serviceInstance;
    }
}
