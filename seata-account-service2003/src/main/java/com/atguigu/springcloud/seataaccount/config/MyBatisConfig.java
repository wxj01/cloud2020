package com.atguigu.springcloud.seataaccount.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/27 0027 16:25
 */
@Configuration
@MapperScan("com.atguigu.springcloud.seataaccount.dao")
public class MyBatisConfig {
}