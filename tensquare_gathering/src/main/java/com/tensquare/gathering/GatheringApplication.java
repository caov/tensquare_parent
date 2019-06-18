package com.tensquare.gathering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @program: tensquare_parent
 * @description: 活动模块启动类
 * @author: cf
 * @create: 2019-06-14 15:14
 */
@EnableCaching
@SpringBootApplication
@EnableEurekaClient
public class GatheringApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatheringApplication.class);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
