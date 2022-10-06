package com.xiaomizhou.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: zhangyaxi
 * @date: 2022-10-06 14:48
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelGatewayServiceExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelGatewayServiceExampleApplication.class, args);
    }
}
