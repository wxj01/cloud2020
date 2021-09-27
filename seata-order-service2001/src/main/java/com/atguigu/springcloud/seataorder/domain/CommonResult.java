package com.atguigu.springcloud.seataorder.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/26 0026 16:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private  T data;

    public CommonResult(Integer code, String message) {
       this(code,message,null);
    }
}