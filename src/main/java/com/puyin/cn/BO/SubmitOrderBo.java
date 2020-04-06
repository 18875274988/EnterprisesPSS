package com.puyin.cn.BO;

import com.puyin.cn.entity.TemporaryPo;
import lombok.Data;

import java.util.List;

/**
 * 描述：提交订单入参
 *
 * @author PuYinsheng
 * @date 2020/4/6
 **/
@Data
public class SubmitOrderBo {
    /**
     * 货物信息
     */
   private List<TemporaryPo> productList;
    /**
     * 客户姓名
     */
    private String clientName;
    /**
     * 客户电话
     */
    private String clientTel;
    /**
     * 客户身份证号
     */
    private String clientNo;

}
