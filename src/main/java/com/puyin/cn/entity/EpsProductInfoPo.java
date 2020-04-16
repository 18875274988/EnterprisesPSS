package com.puyin.cn.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述：
 *
 * @author
 * @date 2020/4/14
 **/
@Data
public class EpsProductInfoPo {
    /**
     * id
     */
    private Integer id;
    /**
     * 商品名称
     */
    private String productName;
    /**
     *
     * 商品数量
     */
    private String productCount;
    /**
     * 商品价格
     */
    private Double productPrice;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date productCreatetime;
    /**
     * 商品来源
     */
    private String productFrom;
    /**
     * 商品分类
     */
    private String productCategory;
    /**
     * 商品所在分区
     */
    private String productLocation;
    /**
     * 预警状态
     */
    private String productState;
    /**
     * 采购价格
     */
    private BigDecimal productPurchasePrice;
    /**
     * 销售价格
     */
    private BigDecimal productSellPrice;
}
