package com.atguigu.springcloud.config;

import com.atguigu.myrule.CustomerRule;
import com.atguigu.myrule.RoundRobinRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    public IRule customerRule(){
//        return  new CustomerRule();
        return  new RoundRobinRule();
    }
}
