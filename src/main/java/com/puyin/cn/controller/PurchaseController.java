package com.puyin.cn.controller;

import com.puyin.cn.BO.PurchaseProductBo;
import com.puyin.cn.BO.PurchaseSubmitBo;
import com.puyin.cn.entity.PurchaseProductInfoPo;
import com.puyin.cn.service.PurchaseService;
import com.puyin.cn.vo.PurchaseVo;
import com.puyin.cn.vo.StockoutPurchaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/4/12
 **/
@RestController
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    /**
     * 查询所有未完成采购单
     * @return
     */
   @RequestMapping("findAllPurchase")
    public List<PurchaseVo> findAllPurchase(){
     return  purchaseService.findAllPurchase();
   }

    /**
     * 根据id查询采购货物详情
     * @param purchaseOrderId
     * @return
     */
    @RequestMapping("findPurchaseById")
    public List<PurchaseProductInfoPo> findPurchaseById(Integer purchaseOrderId) {
        return purchaseService.findPurchaseById(purchaseOrderId);
    }

    /**
     * 提交采购单
     * @param purchaseSubmitBo
     */
    @PostMapping("insertPurchasePriceById")
    public int insertPurchasePriceById(@RequestBody PurchaseSubmitBo purchaseSubmitBo) {
        int rows = purchaseService.insertPurchasePriceById(purchaseSubmitBo);
        return rows;
    }
    /**
     * 提交采购单
     * @param
     */
    @RequestMapping("findAllStockoutPurchase")
    public List<StockoutPurchaseVo>  findAllStockoutPurchase(String purchaseSellName) {
       return purchaseService.findAllStockoutPurchase(purchaseSellName);
    }
}
