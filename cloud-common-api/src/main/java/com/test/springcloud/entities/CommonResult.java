package com.test.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 封装一个返回结果
 *
 * @author lzh
 * @create 2020-03-12 9:28
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> implements Serializable {
    private Integer  code;
    private String message;
    private T data;
    public  CommonResult(Integer code,String message){
        this(code,message,null);
    }
}