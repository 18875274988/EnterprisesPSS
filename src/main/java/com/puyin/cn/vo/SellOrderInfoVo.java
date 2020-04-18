package com.puyin.cn.vo;

import lombok.Data;

/**
 * 描述：销售单详情
 *
 * @author PuYinsheng
 * @date 2020/4/17
 **/
@Data
public class SellOrderInfoVo {
    /**
     * 销售单货物id
     */
    private Long orderId;
    /**
     * 销售单货物名
     */
    private String productName;
    /**
     * 销售单货物价格
     */
    private Double productPrice;
    /**
     * 销售单货物数量
     */
    private String productCount;
    /**
     * 销售单货物小计
     */
    private Double productTotal;
}
