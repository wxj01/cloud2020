package com.atguigu.springcloud.seataorder.dao;

import com.atguigu.springcloud.seataorder.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/26 0026 16:12
 */
@Mapper
public interface OrderDao {

    /**
     * @description: 创建订单
     * @param: * @param: order
     * @return: void
     * @author wangxinjian
     * @date: 2021/9/26 0026 16:14
     */
    void create(Order order);


    /**
     * @description: 修改订单金额
     * @param: * @param: userId
     * @param: status
     * @return: void
     * @author wangxinjian
     * @date: 2021/9/26 0026 16:15
     */
    void update(@Param("userId") Long userId,@Param("status") Integer status);
}
