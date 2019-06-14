package com.tensquare.gathering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @program: tensquare_parent
 * @description: 招聘模块启动类
 * @author: cf
 * @create: 2019-06-14 15:14
 */
@EnableCaching
@SpringBootApplication
public class GatheringApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatheringApplication.class);
    }
}
