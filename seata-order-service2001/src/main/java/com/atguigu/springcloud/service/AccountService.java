package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/26 0026 16:34
 */
@FeignClient("seata-account-service")
public interface AccountService {

    /**
     * @description: 调用账户服务，进行扣款
     * @param: * @param: userId
     * @param: money
     * @return: com.atguigu.springcloud.domain.CommonResult
     * @author wangxinjian
     * @date: 2021/9/26 0026 16:36
     */
    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money);
}
