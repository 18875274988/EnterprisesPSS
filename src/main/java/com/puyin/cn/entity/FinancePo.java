package com.puyin.cn.entity;

import lombok.Data;

/**
 * 描述：收付款信息
 *
 * @author PuYinsheng
 * @date 2020/4/14
 **/
@Data
public class FinancePo {
    /**
     * 收付款来源id
     */
    private Integer orderId;
    /**
     * 收付款人姓名
     */
    private String name;
    /**
     * 收付款金额
     */
    private Double amount;
    /**
     * 收付款人电话
     */
    private String tel;
    /**
     * 收付款人身份证号
     */
    private String no;
}
