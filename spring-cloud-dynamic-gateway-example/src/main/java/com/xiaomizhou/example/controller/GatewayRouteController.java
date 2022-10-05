package com.xiaomizhou.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiaomizhou.example.entity.GatewayRouteEntity;
import com.xiaomizhou.example.service.IGatewayRouteService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: zhangyaxi
 * @date: 2022-10-02 22:18
 */
@RestController
@RequestMapping("/api/gateways")
public class GatewayRouteController {

    @Resource
    private IGatewayRouteService gatewayRouteService;

    @GetMapping(
        value = "",
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public IPage<GatewayRouteEntity> list(GatewayRouteEntity gatewayRouteEntity,
                                          @RequestParam(value = "page", defaultValue = "1") Integer page,
                                          @RequestParam(value = "size", defaultValue = "20") Integer size) {
        return this.gatewayRouteService.findPage(gatewayRouteEntity, page, size);
    }

    @GetMapping(
        value = "{id}",
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public GatewayRouteEntity getOne(@PathVariable("id") String id) {
        return this.gatewayRouteService.findOneRoute(id);
    }

    @PostMapping(
        value = "",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public GatewayRouteEntity create(@RequestBody GatewayRouteEntity gatewayRouteEntity) {
        return this.gatewayRouteService.createRoute(gatewayRouteEntity);
    }

    @PutMapping(
        value = "",
        consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void update(@RequestBody GatewayRouteEntity gatewayRouteEntity) {
        this.gatewayRouteService.updateRoute(gatewayRouteEntity);
    }

    @DeleteMapping(
        value = "{id}"
    )
    public void delete(@PathVariable("id") String id) {
        this.gatewayRouteService.deleteRoute(id);
    }

    @GetMapping(value = "/sync")
    public void synchronizeRedis() {
        this.gatewayRouteService.synchronizeRedis();
    }

}
