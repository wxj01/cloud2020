package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2021/4/14 0014 20:25
 */
@Configurable
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }
}
