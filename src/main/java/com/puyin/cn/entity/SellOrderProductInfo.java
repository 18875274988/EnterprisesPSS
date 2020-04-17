package com.puyin.cn.entity;

import lombok.Data;

/**
 * 描述：销售单货物详情
 *
 * @author PuYinsheng
 * @date 2020/4/17
 **/
@Data
public class SellOrderProductInfo {
    /**
     * 对应销售单id
     */
    private Long orderId;
    /**
     * 货物名
     */
    private String productName;
    /**
     * 货物价格
     */
    private Double productPrice;
    /**
     * 货物数量
     */
    private Integer productCount;
}
