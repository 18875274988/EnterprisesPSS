package com.puyin.cn.dao;

import com.puyin.cn.BO.PurchaseSubmitBo;
import com.puyin.cn.entity.PurchaseOrderPo;
import com.puyin.cn.entity.PurchaseProductInfoPo;
import com.puyin.cn.entity.purchaseOrderProductPo;
import com.puyin.cn.vo.PurchaseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述：操作采购相关表
 *
 * @author PuYinsheng
 * @date 2020/4/10
 **/
@Repository
public interface ProcurementDao {
    /**
     *插入采购单
     * @param purchaseOrderPo
     * @return
     */
    int insertPurchaseOrder(PurchaseOrderPo purchaseOrderPo);

    /**
     * 根据采购单标号查询采购单id
     * @param purchaseOrderNo
     * @return
     */
    Integer selectPurchaseId(String purchaseOrderNo);

    /**
     * 向采购单中插入商品
     * @param list
     * @return
     */
    int insetPurchaseOrderProduct(@Param("list") List<purchaseOrderProductPo> list);

    /**
     * 查询所有未完成采购单
     * @return
     */
    List<PurchaseVo> findAllPurchase();

    /**
     * 根据id查询采购货物信息
     * @param purchaseOrderId
     * @return
     */
    List<PurchaseProductInfoPo> findPurchaseById(Integer purchaseOrderId);

    /**
     * 根据id插入采购价格价格
     * @param purchaseSubmitBo
     * @return
     */
    int insertPurchasePriceById(PurchaseSubmitBo purchaseSubmitBo);
}
