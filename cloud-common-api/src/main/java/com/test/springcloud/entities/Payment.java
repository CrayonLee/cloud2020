package com.test.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lzh
 * @create 2020-03-12 9:24
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
     private Long id;
     private String serial;
}