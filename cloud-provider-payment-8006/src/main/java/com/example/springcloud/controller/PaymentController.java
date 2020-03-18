package com.example.springcloud.controller;

import cn.hutool.core.lang.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzh
 * @create 2020-03-17 22:00
 **/
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String SERVER_PORT;
    @GetMapping(value = "/payment/consul1")
    public String test(){
        return "test";
    }

    @GetMapping(value = "/payment/consul")
    public String paymentConsul() {
        return "com.example.springcloud with consul :" + SERVER_PORT + "\t" + UUID.randomUUID().toString();
    }
}