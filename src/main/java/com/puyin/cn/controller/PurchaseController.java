package com.puyin.cn.controller;

import com.puyin.cn.BO.PurchaseSubmitBo;
import com.puyin.cn.entity.PurchaseProductInfoPo;
import com.puyin.cn.service.PurchaseService;
import com.puyin.cn.vo.PurchaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
     * @param purchaseSubmitBos
     */
    @PostMapping("insertPurchasePriceById")
    public int insertPurchasePriceById(@RequestBody List<PurchaseSubmitBo> purchaseSubmitBos) {
        int rows = purchaseService.insertPurchasePriceById(purchaseSubmitBos);
        return rows;
    }

}
