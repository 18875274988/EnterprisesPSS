package com.puyin.cn.entity;

import lombok.Data;

/**
 * 描述：销售单来源详情
 *
 * @author PuYinsheng
 * @date 2020/4/17
 **/
@Data
public class SellOrderFromInfoPo {
    /**
     * 销售单来源id
     */
    private Long orderFromId;
    /**
     * 客户名
     */
    private String orderFromName;
    /**
     * 客户电话
     */
    private String orderFromTel;
    /**
     * 客户身份证号
     */
    private String orderFromCodeid;
}
