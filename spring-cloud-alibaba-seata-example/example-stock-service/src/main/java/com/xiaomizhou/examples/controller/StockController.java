package com.xiaomizhou.examples.controller;

import com.xiaomizhou.examples.api.IStockApi;
import com.xiaomizhou.examples.service.StockService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: zhangyaxi
 * @date: 2022-10-23 21:04
 */
@RestController
@RequestMapping("/api/stock")
public class StockController implements IStockApi {

    @Resource
    private StockService stockService;

    @Override
    public boolean deduct(String commodityCode, Integer count) {
        stockService.deduct(commodityCode, count);
        return true;
    }
}
