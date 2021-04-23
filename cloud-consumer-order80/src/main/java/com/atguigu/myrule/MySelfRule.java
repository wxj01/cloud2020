package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2021/4/13 0013 22:12
 */
@Configurable
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
