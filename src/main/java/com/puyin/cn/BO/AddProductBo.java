package com.puyin.cn.BO;

import lombok.Data;

/**
 * 描述：添加商品入参
 *
 * @author PuYinsheng
 * @date 2020/4/18
 **/
@Data
public class AddProductBo {
    /**
     * 商品名
     */
    private String productName;
    /**
     *商品数量
     */
    private String productCount;
    /**
     * 商品来源
     */
    private String productFrom;
    /**
     * 商品种类
     */
    private String productCategory;
    /**
     * 商品采购价
     */
    private String productPurchasePrice;
    /**
     * 商品采购价（double类型）
     */
    private Double productPurchasePriceValue;

}
