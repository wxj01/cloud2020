package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wxj
 * @version 1.0.0
 * @ClassName PaymentService.java
 * @Description TODO 使用 fallback 方式是无法获取异常信息的，
 * 如果想要获取异常信息，可以使用 fallbackFactory参数
 * @createTime 2021年09月25日 23:06:00
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)//调用中关闭9003服务提供者
public interface PaymentService
{
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult paymentSQL(@PathVariable("id") Long id);
}
