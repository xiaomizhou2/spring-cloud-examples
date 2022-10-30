package com.xiaomizhou.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: zhangyaxi
 * @date: 2022-10-23 19:55
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.xiaomizhou.examples.feign")
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
