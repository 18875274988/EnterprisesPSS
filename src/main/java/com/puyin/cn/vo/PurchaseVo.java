package com.puyin.cn.vo;

import lombok.Data;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/4/12
 **/
@Data
public class PurchaseVo {
    /**
     * 采购单id
     */
    private Integer purchaseOrderId;
    /**
     * 采购发起人
     */
    private String purchaseSellName;
    /**
     * 采购单编号
     */
    private String purchaseOrderNo;
}
