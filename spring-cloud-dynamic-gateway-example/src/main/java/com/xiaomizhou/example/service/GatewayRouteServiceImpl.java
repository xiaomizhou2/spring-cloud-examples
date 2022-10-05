package com.xiaomizhou.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaomizhou.example.constant.RedisKeyConstant;
import com.xiaomizhou.example.entity.GatewayRouteEntity;
import com.xiaomizhou.example.repository.IGatewayRouteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zhangyaxi
 * @date: 2022-10-03 10:52
 */
@Service
@Slf4j
public class GatewayRouteServiceImpl implements IGatewayRouteService {

    @Resource
    private IGatewayRouteRepository repository;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public IPage<GatewayRouteEntity> findPage(GatewayRouteEntity routeEntity, Integer pageNumber, Integer pageSize) {
        try {
            IPage<GatewayRouteEntity> page = Page.of(pageNumber, pageSize);

            QueryWrapper<GatewayRouteEntity> wrapper = new QueryWrapper<>();
            wrapper.like(routeEntity.getCode() != null,"code", routeEntity.getCode());
            wrapper.like(routeEntity.getName() != null, "name", routeEntity.getName());
            wrapper.like(routeEntity.getUri() != null, "uri", routeEntity.getUri());
            wrapper.orderByAsc("order_no").orderByDesc("last_modified_time");

            IPage<GatewayRouteEntity> result = repository.selectPage(page, wrapper);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GatewayRouteEntity> list() {
        try {
            QueryWrapper<GatewayRouteEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("disabled", false);
            return repository.selectList(wrapper);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GatewayRouteEntity createRoute(GatewayRouteEntity routeEntity) {
        try {
            repository.insert(routeEntity);
            return routeEntity;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateRoute(GatewayRouteEntity routeEntity) {
        try {
            repository.updateById(routeEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GatewayRouteEntity findOneRoute(String id) {
        try {
            return repository.selectById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteRoute(String id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void synchronizeRedis() {
        try {
            Boolean isKey = redisTemplate.hasKey(RedisKeyConstant.ROUTE_KEY);
            if (isKey) {
                redisTemplate.delete(RedisKeyConstant.ROUTE_KEY);
            }

            this.list().forEach(gatewayRouteEntity -> {
                redisTemplate.opsForHash().put(RedisKeyConstant.ROUTE_KEY, gatewayRouteEntity.getCode(), gatewayRouteEntity);
            });

            applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
