package com.xiaomizhou.examples.controller;

import com.xiaomizhou.examples.api.IOrderApi;
import com.xiaomizhou.examples.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: zhangyaxi
 * @date: 2022-10-23 20:28
 */
@RestController
@RequestMapping("/api/order")
public class OrderController implements IOrderApi {

    @Resource
    private OrderService orderService;

    @Override
    public boolean placeOrder(String userId, String commodityCode, Integer count) {
        orderService.placeOrder(userId, commodityCode, count);
        return true;
    }

    /**
     * 下单：插入订单表、扣减库存，提交
     *
     * @return
     */
    @PostMapping("/place/commit")
    public boolean placeOrderCommit() {
        orderService.placeOrder("1", "product-1", 1);
        return true;
    }


    /**
     * 下单：插入订单表、扣减库存，模拟回滚
     *
     * @return
     */
    @PostMapping("/place/rollback")
    public boolean placeOrderRollback() {
        orderService.placeOrder("1", "product-2", 1);
        return true;
    }
}
