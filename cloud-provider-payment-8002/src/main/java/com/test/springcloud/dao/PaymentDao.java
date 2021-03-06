package com.test.springcloud.dao;

import com.test.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lzh
 * @create 2020-03-12 9:33
 **/
@Mapper
public interface PaymentDao {
    public  int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}