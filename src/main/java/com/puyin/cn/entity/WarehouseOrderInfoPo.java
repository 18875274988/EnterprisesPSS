package com.puyin.cn.entity;

import lombok.Data;

/**
 * 描述:商品入库单
 *
 * @author
 * @date 2020/4/16
 **/
@Data
public class WarehouseOrderInfoPo {
    /**
     *id
     */
    private Long warehouseId;
    /**
     * 商品名字
     */
    private String productName;
    /**
     * 采购价
     */
    private  Double productPurchasePrice;
    /**
     * 商品数量
     */
    private String productCount;
    /**
     * 供应商
     */
    private String supplierInfo;
}
