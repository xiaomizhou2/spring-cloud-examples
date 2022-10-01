package com.xiaomizhou.examples.controller;

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

    @GetMapping("/hello")
    public String hello() {
        return "hello, nacos";
    }

}
