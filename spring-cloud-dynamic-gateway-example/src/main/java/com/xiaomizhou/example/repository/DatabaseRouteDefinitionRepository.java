package com.xiaomizhou.example.repository;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.xiaomizhou.example.constant.GatewayConstant;
import com.xiaomizhou.example.constant.RedisKeyConstant;
import com.xiaomizhou.example.entity.GatewayRouteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: zhangyaxi
 * @date: 2022-10-03 12:00
 */
@Slf4j
@Data
@AllArgsConstructor
@Component
public class DatabaseRouteDefinitionRepository implements RouteDefinitionRepository {
    @Resource
    private final RedisTemplate redisTemplate;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        List<GatewayRouteEntity> values = (List<GatewayRouteEntity>) redisTemplate.opsForHash().values(RedisKeyConstant.ROUTE_KEY);
        List<RouteDefinition> list = values.stream().map(this::toRouteDefinition).filter(Objects::nonNull).collect(Collectors.toList());
        log.info("redis 中路由定义条数： {}， {}", list.size(), list);
        return Flux.fromIterable(list);
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return route.flatMap(routeDefinition -> {
            log.info("保存路由信息{}", routeDefinition);
            redisTemplate.opsForHash().put(RedisKeyConstant.ROUTE_KEY, routeDefinition.getId(), toRouteEntity(routeDefinition));
            return Mono.empty();
        });
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        routeId.subscribe(id -> {
            log.info("删除路由信息{}", id);
            redisTemplate.opsForHash().delete(RedisKeyConstant.ROUTE_KEY, id);
        });
        return Mono.empty();
    }

    /**
     * 网关路由实体转换为路由定义
     *
     * @param gatewayRouteEntity 网关路由实体
     * @return 路由定义
     */
    protected RouteDefinition toRouteDefinition(GatewayRouteEntity gatewayRouteEntity) {

        try {
            RouteDefinition result = new RouteDefinition();
            result.setId(gatewayRouteEntity.getCode());
            result.setUri(new URI(gatewayRouteEntity.getUri()));
            result.setOrder(gatewayRouteEntity.getOrderNo());
            result.setPredicates(JSONObject.parseArray(gatewayRouteEntity.getPredicates(), PredicateDefinition.class));
            result.setFilters(JSONObject.parseArray(gatewayRouteEntity.getFilters(), FilterDefinition.class));
            result.setMetadata(JSONObject.parseObject(gatewayRouteEntity.getMetadata(), Map.class));

            if (result.getMetadata() == null) {
                result.setMetadata(Maps.newHashMap());
            }
            result.getMetadata().put(GatewayConstant.ROUTE_METADATA_NAME_ATTR, gatewayRouteEntity.getName());

            return result;
        } catch (Exception e) {
            log.error("数据库网关路由[id: {}]转换为路由定义失败", gatewayRouteEntity.getId(), e);
            return null;
        }
    }

    /**
     * 转换路由定义到路由实体
     *
     * @param routeDefinition 路由定义
     * @return 路由实体
     */
    private GatewayRouteEntity toRouteEntity(RouteDefinition routeDefinition) {
        try {
            GatewayRouteEntity routeEntity = GatewayRouteEntity.builder()
                    .code(routeDefinition.getId())
                    .uri(routeDefinition.getUri().toString())
                    .orderNo(routeDefinition.getOrder())
                    .predicates(JSONObject.toJSONString(routeDefinition.getPredicates()))
                    .filters(JSONObject.toJSONString(routeDefinition.getFilters()))
                    .metadata(JSONObject.toJSONString(routeDefinition.getMetadata()))
                    .build();
            if (routeDefinition.getMetadata() != null) {
                String name = (String) routeDefinition.getMetadata().get(GatewayConstant.ROUTE_METADATA_NAME_ATTR);
                routeEntity.setName(name == null ? routeDefinition.getId() : name);
            }

            return routeEntity;
        } catch (Exception e) {
            log.error("路由定义[id: {}]转换为数据库网关路由失败", routeDefinition.getId(), e);
            return null;
        }
    }
}
