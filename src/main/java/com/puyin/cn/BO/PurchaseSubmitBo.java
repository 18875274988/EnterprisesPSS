package com.puyin.cn.BO;

import lombok.Data;

import java.util.List;

/**
 * 描述：采购单提交
 *
 * @author PuYinsheng
 * @date 2020/4/14
 **/
@Data
public class PurchaseSubmitBo {
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
    /**
     * 供应货物信息
     */
    List<PurchaseProductBo> purchaseProductList;
}
