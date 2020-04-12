package com.puyin.cn.entity;

import lombok.Data;

/**
 * 描述：采购单货物详情
 *
 * @author PuYinsheng
 * @date 2020/4/12
 **/
@Data
public class PurchaseProductInfoPo {
    /**
     * 货物id
     */
    private Integer purchaseOrderId;
    /**
     * 货物名称
     */
    private String productName;
    /**
     * 货物数量
     */
    private String productCount;
    /**
     * 货物采购价
     */
   private Double productPurchasePrice;
}
