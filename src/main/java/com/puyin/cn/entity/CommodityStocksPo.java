package com.puyin.cn.entity;

import lombok.Data;

/**
 * 描述：销售部提交商品库存
 *
 * @author PuYinsheng
 * @date 2020/4/8
 **/
@Data
public class CommodityStocksPo {
    /**
     * 商品id
     */
    private Integer id;
    /**
     * 商品库存
     */
    private  String productCount;
}
