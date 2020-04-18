package com.puyin.cn.vo;

import lombok.Data;


/**
 * 描述：出库单详情
 *
 * @author PuYinsheng
 * @date 2020/4/17
 **/
@Data
public class WarehouseOutInfo {
    /**
     * 商品名
     */
    private String productName;
    /**
     * 商品数量
     */
    private String productCount;
}
