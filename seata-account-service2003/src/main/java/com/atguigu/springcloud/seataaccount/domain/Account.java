package com.atguigu.springcloud.seataaccount.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/27 0027 15:33
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id;
    private Long userId; //用户id
    private BigDecimal total; //总额度
    private BigDecimal used; //已用额度
    private BigDecimal residue; //剩余额度
}