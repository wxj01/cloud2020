package com.atguigu.springcloud.seataaccount.controller;

import com.atguigu.springcloud.seataaccount.domain.CommonResult;
import com.atguigu.springcloud.seataaccount.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/27 0027 16:22
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;


    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId,
                                 @RequestParam("money")BigDecimal money){
        accountService.decrease(money,userId);
        return new CommonResult(200,"扣减账户余额成功");
    }
}