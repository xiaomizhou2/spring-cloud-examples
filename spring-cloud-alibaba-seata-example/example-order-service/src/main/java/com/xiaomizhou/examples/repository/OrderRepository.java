package com.xiaomizhou.examples.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaomizhou.examples.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: zhangyaxi
 * @date: 2022-10-23 20:09
 */
@Mapper
@Repository
public interface OrderRepository extends BaseMapper<OrderEntity> {
}
