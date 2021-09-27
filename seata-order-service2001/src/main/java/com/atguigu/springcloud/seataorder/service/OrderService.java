package com.atguigu.springcloud.seataorder.service;


import com.atguigu.springcloud.seataorder.domain.Order;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/26 0026 16:28
 */
public interface OrderService {

    /** 
     * @description: 创建订单
     * @param: * @param: order 
     * @return: void 
     * @author wangxinjian
     * @date: 2021/9/26 0026 16:29
     */ 
    void create(Order order);
    
}
