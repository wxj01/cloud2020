package com.atguigu.springcloud.seatastorage.service;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/27 0027 14:41
 */
public interface StorageService {

    /**
     * @description:  扣减库存
     * @param: * @param: productId
     * @param: count
     * @return: void
     * @author wangxinjian
     * @date: 2021/9/27 0027 14:42
     */
    void decrease(Long productId,Integer count);
}
