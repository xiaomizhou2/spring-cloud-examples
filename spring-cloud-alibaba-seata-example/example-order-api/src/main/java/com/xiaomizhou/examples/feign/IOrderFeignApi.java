package com.xiaomizhou.examples.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: zhangyaxi
 * @date: 2022-10-23 20:49
 */
@FeignClient(name = "order-service", path = "/api/order")
public interface IOrderFeignApi {
}
