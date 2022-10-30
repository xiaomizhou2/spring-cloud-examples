package com.xiaomizhou.examples.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: zhangyaxi
 * @date: 2022-10-23 20:47
 */
@FeignClient(value = "stock-service", url = "http://127.0.0.1:18080/api/stock")
public interface IStockFeignApi {

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
