package com.xiaomizhou.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: zhangyaxi
 * @date: 2022-10-01 20:28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosDiscoveryExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoveryExampleApplication.class, args);
    }
}
