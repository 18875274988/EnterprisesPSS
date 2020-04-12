package com.puyin.cn.entity;

import lombok.Data;

/**
 * 描述：采购单货物信息
 *
 * @author PuYinsheng
 * @date 2020/4/10
 **/
@Data
public class purchaseOrderProductPo {
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
}