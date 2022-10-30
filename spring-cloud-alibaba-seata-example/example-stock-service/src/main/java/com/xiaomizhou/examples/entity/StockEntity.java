package com.xiaomizhou.examples.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author: zhangyaxi
 * @date: 2022-10-23 20:52
 */
@Data
@SuperBuilder(toBuilder = true)
@TableName("t_stock")
@AllArgsConstructor
@NoArgsConstructor
public class StockEntity {

    private Integer id;
    private String commodityCode;
    private Integer count;

}
