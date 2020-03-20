package com.example.springcloud.controller;

import com.example.springcloud.service.PaymentFeignService;
import com.test.springcloud.entities.CommonResult;
import com.test.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lzh
 * @create 2020-03-19 10:56
 **/
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentServiceFeign;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        return paymentServiceFeign.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String timeout(){
        //模拟超时错误,默认客户端等待1s钟
        return paymentServiceFeign.timeout();
    }
}