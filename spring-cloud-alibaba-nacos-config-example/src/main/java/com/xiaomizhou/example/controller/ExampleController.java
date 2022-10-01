package com.xiaomizhou.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhangyaxi
 * @date: 2022-10-01 20:38
 */
@RestController
@RequestMapping("/examples")
public class ExampleController {

    @Value("${example.value}")
    private String value;

    @GetMapping("/hello")
    public String hello() {
        return "hello," + value;
    }

}
