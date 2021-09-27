package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/26 0026 16:30
 */

@FeignClient("seata-storage-service")
public interface StorageService {
    
    /** 
     * @description:  调用库存服务，进行减库存
     * @param: * @param: productId
     * @param: count
     * @return: com.atguigu.springcloud.domain.CommonResult 
     * @author wangxinjian
     * @date: 2021/9/26 0026 16:33
     */ 
    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
