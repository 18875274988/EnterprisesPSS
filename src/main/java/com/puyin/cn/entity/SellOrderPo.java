package com.puyin.cn.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述：销售单
 *
 * @author PuYinsheng
 * @date 2020/4/17
 **/
@Data
public class SellOrderPo {
    /**
     * 销售单id
     */
    private Long orderId;
    /**
     * 销售单编号
     */
    private String orderNo;
    /**
     * 销售单总价
     */
    private String orderPrice;
    /**
     * 销售单创建人
     */
    private String orderCreator;
    /**
     * 销售单创建时间
     */
    private Date orderCreatetime;
    /**
     * 销售单状态
     */
    private Integer orderState;
}
