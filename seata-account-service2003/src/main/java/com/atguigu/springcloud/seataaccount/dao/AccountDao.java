package com.atguigu.springcloud.seataaccount.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/27 0027 15:39
 */
@Mapper
public interface AccountDao {

    /** 
     * @description: 扣减账户money
     * @param: * @param: userId
     * @param: money
     * @return: void 
     * @author wangxinjian
     * @date: 2021/9/27 0027 15:40
     */ 
    void decrease(@Param("userId") Long userId, @Param("money")BigDecimal money);
}
