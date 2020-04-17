package com.puyin.cn.dao;

import com.puyin.cn.BO.PurchaseProductBo;
import com.puyin.cn.BO.UpdataPrewarningValueBo;
import com.puyin.cn.entity.*;
import com.puyin.cn.vo.PurchaseVo;
import com.puyin.cn.vo.StockoutPurchaseVo;
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
     * @param purchaseProductInfoPo
     * @return
     */
    int insertPurchasePriceById(PurchaseProductInfoPo purchaseProductInfoPo);

    /**
     * 根据id查询采购价格(用于判断该采购商品是否都已采购)
     * @param purchaseOrderId
     * @return
     */
    List<Long> findPurchasePriceById(Integer purchaseOrderId);

    /**
     * 采购完成调用
     * @param purchaseOrderId
     * @return
     */
    int purchaseOrderAccomplish(Integer purchaseOrderId);

    /**
     * 根据采购id查询对应订单编号
     * @param purchaseOrderId
     * @return
     */
    String findOrderOnByPurchaseId(Integer purchaseOrderId);

    /**
     * 采购完成修改订单状态
     * @param orderNo
     * @return
     */
    int updateSellOrderState(String orderNo);

    /**
     * 查询采购单状态
     * @return
     */
    List<StockoutPurchaseVo> findAllStockoutPurchase(String purchaseSellName);

    /**
     * 生成付款单
     * @param financePo
     * @return
     */
    int insertFinance(FinancePo financePo);

    /**
     * 根据商品id求价格和
     * @param name
     * @return
     */
    Double findSumPriceById(String name);

    /**
     * 生成出库单
     * @param warehouseNo
     * @return
     */
    int AddOutboundOrder(String warehouseNo);
    /**
     * 根据出库单编导查询id
     * @param warehouseNo
     * @return
     */
    Long findNOBywarehouseId(String warehouseNo);

    /**
     * 生成出库单详情页
     * @param productName
     * @param productCount
     * @param id
     * @return
     */
    int addOutboundOrderInfo(@Param("productName") String productName,@Param("productCount") String productCount,@Param("id") Long id);

    /**
     * 生成商品入库单
     * @param warehouseNo
     * @return
     */
    int addWarehouseOrder(String warehouseNo);

    /**
     * 根据编号查入库单id
     * @param warehouseNo
     * @return
     */
    Long findWarehouseOrderIdByNo(String warehouseNo);
    /**
     * 插入入库单详情页
     * @param warehouseOrderInfoPo
     * @return
     */
    int insertWarehouseProduct(WarehouseOrderInfoPo warehouseOrderInfoPo);

    /**
     * 根据id查询采购货物信息
     * @param id
     * @return
     */
    List<PurchaseOrderByIdPo> findAllPurchaseById(Long id);
}
