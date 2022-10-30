package com.xiaomizhou.examples.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaomizhou.examples.entity.StockEntity;
import com.xiaomizhou.examples.repository.IStockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: zhangyaxi
 * @date: 2022-10-23 20:59
 */
@Service
public class StockService {

    @Resource
    private IStockRepository stockRepository;

    /**
     * 扣库存
     * @param commodityCode
     * @param count
     */
    @Transactional(rollbackFor = Exception.class)
    public void deduct(String commodityCode, int count) {
        if (commodityCode.equals("product-2")) {
            throw new RuntimeException("异常:模拟业务异常:stock branch exception");
        }

        QueryWrapper<StockEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("commodity_code", commodityCode);
        StockEntity entity = stockRepository.selectOne(wrapper);
        entity.setCount(entity.getCount() - count);

        stockRepository.updateById(entity);
    }

}
