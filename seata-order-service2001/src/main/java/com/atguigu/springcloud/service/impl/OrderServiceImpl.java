package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/26 0026 16:37
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("-----------> 下单开始 ");
        // 本应用创建订单
        orderDao.create(order);

        // 远程调用库存服务 扣库存
        log.info("-----------> storage-service 中 扣减库存 开始 ");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("-----------> storage-service 中 扣减库存 完成 ");

        //远程调用账户服务 扣款
        log.info("-----------> account-service 中 扣款 开始 ");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("-----------> account-service 中 扣款 完成 ");

        //修改订单状态为已完成
        log.info("-----------> order-service 中 修改订单状态 开始 ");
        orderDao.update(order.getUserId(),order.getStatus());
        log.info("-----------> order-service 中 修改订单状态 完成 ");

        log.info("------->下单结束");

    }
}