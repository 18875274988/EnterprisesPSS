package com.puyin.cn.BO;

import lombok.Data;

/**
 * 描述：客户信息
 *
 * @author PuYinsheng
 * @date 2020/4/7
 **/
@Data
public class ClientInfoBo {
    /**
     * 客户电话
     */
    private String clientTel;
    /**
     * 客户身份证号
     */
    private String clientNo;
}
