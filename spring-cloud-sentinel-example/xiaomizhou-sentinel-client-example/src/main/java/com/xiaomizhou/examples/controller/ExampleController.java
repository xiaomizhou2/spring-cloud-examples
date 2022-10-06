package com.xiaomizhou.examples.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhangyaxi
 * @date: 2022-10-06 14:35
 */
@RestController
@RequestMapping("/examples")
public class ExampleController {

    @GetMapping("/hello")
    @SentinelResource("hello")
    public String hello() {
        return "hello";
    }

}
