package com.puyin.cn.service;

import com.puyin.cn.BO.PurchaseSubmitBo;
import com.puyin.cn.entity.PurchaseProductInfoPo;
import com.puyin.cn.vo.PurchaseVo;

import java.util.List;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/4/12
 **/
public interface PurchaseService {
    /**
     * 查询所有未完成采购单
     * @return
     */
    List<PurchaseVo> findAllPurchase();

    /**
     * 根据id查询采购货物详情
     * @param purchaseOrderId
     * @return
     */
    List<PurchaseProductInfoPo> findPurchaseById(Integer purchaseOrderId);
    /**
     * 根据id插入采购价格价格
     * @param purchaseSubmitBos
     * @return
     */
    int insertPurchasePriceById(List<PurchaseSubmitBo> purchaseSubmitBos);
}
