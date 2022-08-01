package com.atguigu.springcloud;

import com.atguigu.myrule.RoundRobinRule;
import com.atguigu.springcloud.config.CustomerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2021/4/11 0011 15:50
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = CustomerConfig.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }


//    @Bean
//    @LoadBalanced //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }
}
