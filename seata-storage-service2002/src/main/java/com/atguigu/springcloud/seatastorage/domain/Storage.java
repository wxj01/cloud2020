package com.atguigu.springcloud.seatastorage.domain;

import lombok.Data;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/27 0027 14:11
 */
@Data
public class Storage {
    private Long id;
//    产品id
    private Long productId;
//    总库存
    private Integer total;
//    已用库存
    private Integer used;
//    剩余库存
    private Integer residue;
}