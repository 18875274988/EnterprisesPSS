package com.puyin.cn.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 描述：入库单详情vo
 *
 * @author PuYinsheng
 * @date 2020/4/17
 **/
@Data
public class WarehouseEnterVO {
    /**
     * id
     */
    private Long warehouseId;
    /**
     * 货物名
     */
    private String productName;
    /**
     * 货物价格
     */
    private BigDecimal productPurchasePrice;
    /**
     * 货物数量
     */
    private String productCount;
    /**
     * 供应商信息
     */
    private String supplierInfo;
    /**
     * 货物类别
     */
    private String category;
}
