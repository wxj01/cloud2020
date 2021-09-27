package com.atguigu.springcloud.seataorder.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/26 0026 16:53
 */
@Configuration
@MapperScan({"com.atguigu.springcloud.seataorder.dao"})
public class MyBatisConfig {
}