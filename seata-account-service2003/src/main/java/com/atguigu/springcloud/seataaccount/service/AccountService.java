package com.atguigu.springcloud.seataaccount.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/27 0027 16:15
 */
public interface AccountService {


    /**
     * @description: 扣减 账户 money
     * @param: * @param: money
     * @param: userId
     * @return: void
     * @author wangxinjian
     * @date: 2021/9/27 0027 16:17
     */
    void decrease(@Param("money")BigDecimal money,@Param("userId") Long userId);
}
