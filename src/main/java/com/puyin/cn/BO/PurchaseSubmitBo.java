package com.puyin.cn.BO;

import lombok.Data;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/4/12
 **/
@Data
public class PurchaseSubmitBo {
    /**
     * 货物id
     */
    private Integer purchaseOrderId;
    /**
     * 货物名称
     */
    private String productName;
    /**
     * 货物采购价
     */
    private Double productPurchasePrice;
}
