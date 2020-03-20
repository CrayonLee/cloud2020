package com.test.springcloud.controller;

import com.test.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import com.test.springcloud.entities.CommonResult;
import com.test.springcloud.entities.Payment;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lzh
 * @create 2020-03-12 10:13
 **/
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果------->"+result);
        if(result>0){
            return new CommonResult<Payment>(200,"插入成功 serverPort:"+serverPort);
        }else{
            return new CommonResult<Payment>(500,"插入失败",null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果------->"+payment+"\t" +"O(∩_∩)O哈哈~-------");
        if(payment!=null){
            return new CommonResult<Payment>(200,"查询成功 O(∩_∩)O哈哈~ serverPort: "+serverPort,payment);
        }else{
            return new CommonResult<Payment>(500,"没有对应记录,查询id"+id,null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {

            log.info("***********  service:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instances+"---"+instance.getHost()+"---"+instance.getPort()+"---"+instance.getUri());
        }

        return discoveryClient;
    }

    @GetMapping("/payment/feign/timeout")
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }




}