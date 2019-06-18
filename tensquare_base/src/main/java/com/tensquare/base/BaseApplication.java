package com.tensquare.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @program: tensquare_parent
 * @description: 基础模块启动类
 * @author: cf
 * @create: 2019-06-10 22:46
 */
@SpringBootApplication
@EnableEurekaClient
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
