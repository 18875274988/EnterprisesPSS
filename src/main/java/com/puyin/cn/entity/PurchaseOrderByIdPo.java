package com.puyin.cn.entity;

import lombok.Data;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/4/16
 **/
@Data
public class PurchaseOrderByIdPo {
    /**
     * 货物id
     */
    private Integer purchaseOrderId;
    /**
     * 货物名称
     */
    private String productName;
    /**
     * 采购数量
     */
    String productCount;
    /**
     * 货物采购价
     */
    private Double productPurchasePrice;
    /**
     * 采购商姓名
     */
    private String supplierName;
    /**
     * 采购商电话
     */
    private String supplierTel;
    /**
     * 采购商身份证号
     */
    private String supplierNo;
}
