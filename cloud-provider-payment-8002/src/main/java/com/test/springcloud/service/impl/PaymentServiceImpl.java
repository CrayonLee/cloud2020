package com.test.springcloud.service.impl;

import com.test.springcloud.entities.Payment;
import org.springframework.stereotype.Service;
import com.test.springcloud.dao.PaymentDao;
import com.test.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author lzh
 * @create 2020-03-12 10:10
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}