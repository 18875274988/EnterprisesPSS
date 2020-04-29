package com.puyin.cn.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 描述：查询出库单出参
 *
 * @author PuYinsheng
 * @date 2020/4/17
 **/
@Data
public class WarehouseOutVo {
    /**
     * 出库单id
     */
    private Long warehouseId;
    /**
     * 出库单编号
     */
    private String warehouseNo;
    /**
     * 出库单创建时间
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    private Date warehouseStarttime;
}
