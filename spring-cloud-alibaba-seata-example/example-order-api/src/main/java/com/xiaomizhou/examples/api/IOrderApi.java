package com.xiaomizhou.examples.api;

import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: zhangyaxi
 * @date: 2022-10-23 20:13
 */
public interface IOrderApi {

    /**
     * 下单
     *
     * @param userId
     * @param commodityCode
     * @param count
     * @return
     */
    @PostMapping("/place")
    boolean placeOrder(String userId, String commodityCode, Integer count);
}
