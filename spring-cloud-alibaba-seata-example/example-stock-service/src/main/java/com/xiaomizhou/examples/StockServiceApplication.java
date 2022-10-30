package com.xiaomizhou.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: zhangyaxi
 * @date: 2022-10-23 20:51
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class StockServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockServiceApplication.class, args);
    }
}
