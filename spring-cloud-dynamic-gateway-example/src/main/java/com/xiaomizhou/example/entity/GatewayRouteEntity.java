package com.xiaomizhou.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zhangyaxi
 * @date: 2022-10-02 21:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode()
@TableName("t_gateway_route")
public class GatewayRouteEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private String id;

    private String code;

    private String name;

    private String uri;

    private String predicates;

    private String filters;

    private String metadata;

    private Integer orderNo;

    private Date createdTime;

    private Date lastModifiedTime;

}
