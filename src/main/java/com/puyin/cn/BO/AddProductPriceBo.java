package com.puyin.cn.BO;

import lombok.Data;

/**
 * 描述：添加货物单价
 *
 * @author PuYinsheng
 * @date 2020/4/28
 **/
@Data
public class AddProductPriceBo {
    /**
     * 货物id
     */
    private Long id;
    /**
     * 货物单价
     */
    private String price;
}
