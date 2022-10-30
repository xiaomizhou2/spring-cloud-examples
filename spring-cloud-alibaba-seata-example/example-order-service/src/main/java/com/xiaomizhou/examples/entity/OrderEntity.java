package com.xiaomizhou.examples.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author: zhangyaxi
 * @date: 2022-10-23 20:04
 */
@Data
@TableName("t_order")
@SuperBuilder(toBuilder = true)
public class OrderEntity {

    private Integer id;
    private String userId;
    private String commodityCode;
    private Integer count;
    private BigDecimal money;

}
