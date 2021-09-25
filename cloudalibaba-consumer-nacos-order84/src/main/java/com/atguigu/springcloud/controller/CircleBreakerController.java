package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wxj
 * @version 1.0.0
 * @ClassName CircleBreakerController.java
 * @Description TODO
 * @createTime 2021年09月24日 23:22:00
 */
@RestController
@Slf4j
public class CircleBreakerController
{
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback负责业务异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler负责sentinel 里面配置的降级限流
//        @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler") //fallback负责业务异常
        @SentinelResource(value = "fallback",fallback = "handlerFallback",
                blockHandler = "blockHandler",exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult fallback(@PathVariable Long id)
    {
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id,CommonResult.class,id);

        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }

    // 本例是 fallback
    public CommonResult handlerFallback(@PathVariable  Long id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult(444,"fallback,无此流水,exception  "+e.getMessage(),payment);
    }
    // 本例是 blockHandler
    public CommonResult blockHandler(@PathVariable  Long id,BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new CommonResult(445,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }

    //==================OpenFeign
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/openfeign/{id}")
    public CommonResult paymentSQL(@PathVariable("id") Long id)
    {
        if(id == 4)
        {
            throw new RuntimeException("没有该id");
        }
        return paymentService.paymentSQL(id);
    }
}
