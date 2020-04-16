package com.puyin.cn.entity;

import lombok.Data;

/**
 * 描述：根据预警值修改商品信息po
 *
 * @author PuYinsheng
 * @date 2020/4/14
 **/
@Data
public class UpdataProductStateByIdPo {
    /**
     *商品id
     */
    private Long productId;
    /**
     * 商品库存
     */
    private Double productCount;
}
