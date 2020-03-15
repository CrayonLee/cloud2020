package com.test.springcloud.controller;

import com.test.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.test.springcloud.entities.CommonResult;
import com.test.springcloud.entities.Payment;

import javax.annotation.Resource;

/**
 * @author lzh
 * @create 2020-03-12 10:13
 **/
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果------->"+result);
        if(result>0){
            return new CommonResult<Payment>(200,"插入成功");
        }else{
            return new CommonResult<Payment>(500,"插入失败",null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果------->"+payment+"\t" +"O(∩_∩)O哈哈~-------");
        if(payment!=null){
            return new CommonResult<Payment>(200,"查询成功 O(∩_∩)O哈哈~",payment);
        }else{
            return new CommonResult<Payment>(500,"没有对应记录,查询id"+id,null);
        }
    }




}