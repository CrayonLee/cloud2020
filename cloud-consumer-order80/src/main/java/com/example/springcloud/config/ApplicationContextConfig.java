package com.example.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lzh
 * @create 2020-03-13 18:42
 **/
@Configuration
public class ApplicationContextConfig {
    @Bean
    public  RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}