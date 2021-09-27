package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/26 0026 16:48
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /** 
     * @description: 创建订单
     * @param: * @param: order 
     * @return: com.atguigu.springcloud.domain.CommonResult 
     * @author wangxinjian
     * @date: 2021/9/26 0026 16:52
     */ 
    @GetMapping("/create/order")
    public CommonResult create(Order order){

        orderService.create(order);
        return new CommonResult(200,"创建订单成功");
    }
}