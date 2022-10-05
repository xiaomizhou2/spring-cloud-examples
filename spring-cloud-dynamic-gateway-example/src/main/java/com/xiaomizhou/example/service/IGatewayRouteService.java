package com.xiaomizhou.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiaomizhou.example.entity.GatewayRouteEntity;

import java.util.List;

/**
 * @author: zhangyaxi
 * @date: 2022-10-03 10:52
 */
public interface IGatewayRouteService {

    /**
     * 分页查询路由列表
     *
     * @param routeEntity 查询对象
     * @param pageNumber 当前页
     * @param pageSize 页数据大小
     * @return
     */
    IPage<GatewayRouteEntity> findPage(GatewayRouteEntity routeEntity, Integer pageNumber, Integer pageSize);

    /**
     * 获取所有路由
     *
     * @return
     */
    List<GatewayRouteEntity> list();

    /**
     * 创建路由
     *
     * @param routeEntity
     * @return
     */
    GatewayRouteEntity createRoute(GatewayRouteEntity routeEntity);

    /**
     * 更新路由
     *
     * @param routeEntity
     * @return
     */
    void updateRoute(GatewayRouteEntity routeEntity);

    /**
     * 根据ID查询路由详细信息
     *
     * @param id
     * @return
     */
    GatewayRouteEntity findOneRoute(String id);

    /**
     * 删除路由
     *
     * @param id
     */
    void deleteRoute(String id);

    /**
     * 同步路由信息到redis
     */
    void synchronizeRedis();

}
