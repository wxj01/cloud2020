//package com.atguigu.springcloud.myrule;
//
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Bean;
//
///**
// * @author Administrator
// * @version 1.0
// * @description: TODO
// * @date 2021/4/13 0013 22:12
// *
// * 这里不是说 自定义的MySelfRule 不能和主启动类 所能扫到的包下吗，这里测试也是可以的的
// */
//@Configurable
//public class MySelfRule {
//
//    @Bean
//    public IRule myRule(){
//        return new RandomRule();
//    }
//}
