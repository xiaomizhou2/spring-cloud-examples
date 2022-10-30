package com.xiaomizhou.examples.service;

import com.xiaomizhou.examples.entity.OrderEntity;
import com.xiaomizhou.examples.feign.IStockFeignApi;
import com.xiaomizhou.examples.repository.OrderRepository;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author: zhangyaxi
 * @date: 2022-10-23 20:18
 */
@Service
public class OrderService {

    @Resource
    private OrderRepository orderRepository;

    @Autowired
    private IStockFeignApi stockFeignApi;

    /**
     * 下单流程
     *
     * @param userId
     * @param commodityCode
     * @param count
     */
    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    public void placeOrder(String userId, String commodityCode, Integer count) {
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));
        OrderEntity orderEntity = OrderEntity.builder()
                .userId(userId)
                .commodityCode(commodityCode)
                .count(count)
                .money(orderMoney).build();

        orderRepository.insert(orderEntity);

        //扣减库存
        stockFeignApi.deduct(commodityCode, count);
    }

}
