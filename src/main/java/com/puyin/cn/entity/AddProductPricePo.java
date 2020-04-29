package com.puyin.cn.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 描述：待定价商品信息
 *
 * @author PuYinsheng
 * @date 2020/4/28
 **/
@Data
public class AddProductPricePo {
    /**
     * 商品id
     */
    private Long id;
    /**
     * 货物名称
     */
    private String productName;
    /**
     * 采购价
     */
    private BigDecimal productPurchasePrice;

}
