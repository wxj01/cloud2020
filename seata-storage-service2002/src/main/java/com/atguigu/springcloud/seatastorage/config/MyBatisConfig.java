package com.atguigu.springcloud.seatastorage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/27 0027 15:02
 */
@Configuration
@MapperScan({"com.atguigu.springcloud.seatastorage.dao"})
public class MyBatisConfig {
}