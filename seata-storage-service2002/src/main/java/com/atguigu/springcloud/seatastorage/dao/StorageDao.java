package com.atguigu.springcloud.seatastorage.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/27 0027 14:27
 */
@MapperScan
public interface StorageDao {

    /**
     * @description:  扣减库存
     * @param: * @param: productId
 * @param: count
     * @return: void
     * @author wangxinjian
     * @date: 2021/9/27 0027 14:28
     */
    void decrease(@Param("productId") Long productId,@Param("count") Integer count);
}
