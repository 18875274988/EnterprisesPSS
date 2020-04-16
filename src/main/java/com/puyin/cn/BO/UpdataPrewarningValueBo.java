package com.puyin.cn.BO;

import lombok.Data;

/**
 * 描述：根据id修改预警值入参
 *
 * @author PuYinsheng
 * @date 2020/4/14
 **/
@Data
public class UpdataPrewarningValueBo {
    /**
     * 货物id
     */
    Long productId;
    /**
     * 货物预警值
     */
    private Integer prewarningValue;
}
