package com.puyin.cn.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/31
 **/
@Data
@Accessors(chain = true)
public class TemporaryPo {
    /**
     * 货物id
     */
    private Integer id;
    /**
     * 货物下单数量
     */
    private Integer count;
    /**
     * 客户名
     */
    private String clientName;
    /**
     * 客户身份证号
     */
    private String clientId;
    /**
     * 客户电话
     */
    private  String clientTel;
}
