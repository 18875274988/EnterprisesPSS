package com.puyin.cn.service;

import com.puyin.cn.BO.AddProductPriceBo;
import com.puyin.cn.BO.SubmitOrderBo;
import com.puyin.cn.entity.AddProductPricePo;
import com.puyin.cn.entity.CategroyPo;
import com.puyin.cn.entity.CommodityStocksPo;
import com.puyin.cn.entity.TemporaryPo;
import com.puyin.cn.vo.SalesVo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/30
 **/
public interface SalesService {
    List<SalesVo> findAllProduct();
    List<CategroyPo> finfAllCategroy();
    /**
     * 向临时表插入待下单货物
     */
     int intsertTemporary(TemporaryPo temporaryPo);

    /**
     * 查询临时货物信息
     * @param accountName
     * @return
     */
     List<TemporaryPo> selectTemporary(String accountName);

    /**
     * 查询销售部提交订单货物库存是否缺货
     * @param submitOrderBo
     * @return
     */
     int findProductCount(SubmitOrderBo submitOrderBo);

    /**
     * 生成销售单(分为缺货不缺货两种单)
     * @param submitOrderBo
     * @param state
     * @param orderNo
     */
     Long addOrder(SubmitOrderBo submitOrderBo,int state,String orderNo);

    /**
     * 生成收款单
     * @param submitOrderBo
     * @param state
     * @param orderId
     */
     void addReceipt(SubmitOrderBo submitOrderBo,int state,Long orderId);
    /**
     * 查询为定价无货信息
     * @return
     */
    List<AddProductPricePo> findAllNoPriceProducyt();

    /**
     * 添加货物单价
     * @param addProductPriceBo
     * @return
     */
    int AddProductPrice(AddProductPriceBo addProductPriceBo);

}
