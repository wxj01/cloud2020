package com.atguigu.springcloud.seatastorage.service.impl;

import com.atguigu.springcloud.seatastorage.dao.StorageDao;
import com.atguigu.springcloud.seatastorage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/27 0027 14:42
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("--------------> storage-service 开始扣减库存 开始 ");
        storageDao.decrease(productId,count);
        log.info("--------------> storage-service 开始扣减库存 完成");
    }
}