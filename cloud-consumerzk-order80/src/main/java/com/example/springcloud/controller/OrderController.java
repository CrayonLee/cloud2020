package com.example.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lzh
 * @create 2020-03-16 23:09
 **/
@RestController
public class OrderController {
    public static final String INVOKE_URL ="http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }
}