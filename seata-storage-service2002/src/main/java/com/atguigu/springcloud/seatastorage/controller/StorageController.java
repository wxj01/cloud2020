package com.atguigu.springcloud.seatastorage.controller;

import com.atguigu.springcloud.seatastorage.domain.CommonResult;
import com.atguigu.springcloud.seatastorage.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/27 0027 14:54
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult decrease(Long productId,Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功");
    }
}