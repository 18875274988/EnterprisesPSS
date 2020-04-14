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
    /**
     * 供应商姓名
     */
    private  String supplierName;
    /**
     * 供应商电话
     */
    private String  supplierTel;
    /**
     * 供应商商身份证号
     */
    private  String supplierNo;
}
