package com.xiaomizhou.example.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaomizhou.example.entity.GatewayRouteEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: zhangyaxi
 * @date: 2022-10-02 22:10
 */
@Repository
@Mapper
public interface IGatewayRouteRepository extends BaseMapper<GatewayRouteEntity> {
}
