package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author wxj
 * @version 1.0.0
 * @ClassName LoadBalancer.java
 * @Description TODO 自定义负责接口
 * @createTime 2022年05月21日 13:10:00
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
