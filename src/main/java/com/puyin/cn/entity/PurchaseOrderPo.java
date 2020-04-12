package com.puyin.cn.entity;

import lombok.Data;

/**
 * 描述：采购单
 *
 * @author PuYinsheng
 * @date 2020/4/10
 **/
@Data
public class PurchaseOrderPo {
    /**
     * 采购单id
     */
    private Integer purchaseOrderId;
    /**
     * 采购单编号
     */
    private String purchaseOrderNo;
    /**
     * 采购发起人
     */
    private String purchaseSellName;
    /**
     * 供应商姓名
     */
    private String supplierName;
    /**
     * 供应商电话
     */
    private String supplierTel;
    /**
     * 供应商身份证号
     */
    private String supplierNo;
    /**
     * 采购单状态
     */
    private Integer purchaseOrderState;
}
