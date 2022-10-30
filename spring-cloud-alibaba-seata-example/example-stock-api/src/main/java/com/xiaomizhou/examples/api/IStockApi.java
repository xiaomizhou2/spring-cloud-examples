package com.xiaomizhou.examples.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: zhangyaxi
 * @date: 2022-10-23 20:42
 */
public interface IStockApi {

    /**
     * 扣减库存
     *
     * @param commodityCode
     * @param count
     * @return
     */
    @GetMapping("/deduct")
    boolean deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count);

}
