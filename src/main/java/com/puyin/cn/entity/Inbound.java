package com.puyin.cn.entity;

import lombok.Data;

/**
 * 描述：
 *
 * @author
 * @date 2020/4/16
 **/
@Data
public class Inbound {
    /**
     * id
     */
    private Long warehouseId;
    /**
     * 订单号
     */
    private String warehouseNo;
    /**
     * 开始时间
     */
    private  String startTime;
}
