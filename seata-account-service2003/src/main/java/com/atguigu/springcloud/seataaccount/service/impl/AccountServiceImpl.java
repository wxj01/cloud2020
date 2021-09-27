package com.atguigu.springcloud.seataaccount.service.impl;

import com.atguigu.springcloud.seataaccount.dao.AccountDao;
import com.atguigu.springcloud.seataaccount.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/27 0027 16:17
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    /**
     * @description: 扣减账户money
     * @param: * @param: money
     * @param: userId
     * @return: void
     * @author wangxinjian
     * @date: 2021/9/27 0027 16:19
     */
    @Override
    public void decrease(BigDecimal money, Long userId) {
        log.info("------->account-service中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
        // 暂停几秒
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        accountDao.decrease(userId,money);

        log.info("------->account-service中扣减账户余额结束");
    }
}