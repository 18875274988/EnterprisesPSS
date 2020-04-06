package com.puyin.cn.BO;

import lombok.Data;

/**
 * 描述：加入购物车入参
 *
 * @author PuYinsheng
 * @date 2020/3/31
 **/
@Data
public class TemporaryProductBo {
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
    private String name;
    /**
     * 货物单价
     */
    private Double productPrice;

}
