package com.test.springcloud.service;

import com.test.springcloud.entities.Payment;

/**
 * @author lzh
 * @create 2020-03-12 10:09
 **/
public interface PaymentService {
    public  int create(Payment payment);
    public Payment getPaymentById(Long id);
}