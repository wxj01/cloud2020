package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author wxj
 * @version 1.0.0
 * @ClassName PaymentFallbackService.java
 * @Description TODO
 * @createTime 2021年09月25日 23:11:00
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult paymentSQL(Long id) {
        {
            return new CommonResult(444,"服务降级返回,没有该流水信息",new Payment(id, "errorSerial......"));
        }
    }
}
