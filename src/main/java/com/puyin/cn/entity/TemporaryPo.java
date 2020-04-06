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
     * 货物名称
     */
    private String productName;
    /**
     * 货物数量
     */
    private  Integer count;
    /**
     * 下单销售员账户名
     */
    private String accountName;
    /**
     * 货物单价
     */
    private Double productPrice;

}
