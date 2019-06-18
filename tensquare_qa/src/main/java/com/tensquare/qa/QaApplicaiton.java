package com.tensquare.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import util.IdWorker;
import util.JwtUtil;

/**
 * @program: tensquare_parent
 * @description: 问答模块启动类
 * @author: cf
 * @create: 2019-06-14 10:23
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class QaApplicaiton {
    public static void main(String[] args) {
        SpringApplication.run(QaApplicaiton.class);
    }

    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
