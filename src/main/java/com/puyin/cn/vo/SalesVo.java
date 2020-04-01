package com.puyin.cn.vo;

import lombok.Data;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/30
 **/
@Data
public class SalesVo {
    /**
     * 标识符
     */
    private Long id;
    /**
     * 货物名称
     */
    private String productName;
    /**
     * 货物库存
     */
    private String productCount;
    /**
     * 货物种类
     */
    private String productCategory;
    /**
     * 货物价格
     */
    private Double productPrice;
}
