package com.atguigu.springcloud;

import com.atguigu.springcloud.config.CustomerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2021/4/13 0013 20:42
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "consul-provider-payment ",configuration = CustomerConfig.class)
public class OrderConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class,args);
    }
}
