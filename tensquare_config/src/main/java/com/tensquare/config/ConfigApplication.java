package com.tensquare.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @program: tensquare_parent
 * @description: 配置中心启动类
 * @author: cf
 * @create: 2019-06-19 16:24
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class);
    }
}
