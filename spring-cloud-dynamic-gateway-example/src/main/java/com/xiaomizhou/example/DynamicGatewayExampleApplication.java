package com.xiaomizhou.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: zhangyaxi
 * @date: 2022-10-02 20:17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DynamicGatewayExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(DynamicGatewayExampleApplication.class, args);
    }
}
