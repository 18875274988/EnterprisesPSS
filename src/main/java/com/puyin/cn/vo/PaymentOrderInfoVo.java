package com.puyin.cn.vo;

import lombok.Data;

/**
 * 描述：来料付款单详情页(单个商品)
 *
 * @author PuYinsheng
 * @date 2020/4/14
 **/
@Data
public class PaymentOrderInfoVo {
    /**
     * 商品名
     */
    private String productName;
    /**
     * 商品数量
     */
    private String productCount;
    /**
     * 采购单价
     */
    private Double productPurchasePrice;
    /**
     * 该个商品小计
     */
    private  Double  subTotal;

}
