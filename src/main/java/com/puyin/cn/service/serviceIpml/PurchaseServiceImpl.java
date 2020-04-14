package com.puyin.cn.service.serviceIpml;

import com.puyin.cn.BO.PurchaseProductBo;
import com.puyin.cn.BO.PurchaseSubmitBo;
import com.puyin.cn.dao.ProcurementDao;
import com.puyin.cn.entity.FinancePo;
import com.puyin.cn.entity.PurchaseProductInfoPo;
import com.puyin.cn.service.PurchaseService;
import com.puyin.cn.vo.PurchaseVo;
import com.puyin.cn.vo.StockoutPurchaseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/4/12
 **/
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private ProcurementDao procurementDao;
    @Override
    public List<PurchaseVo> findAllPurchase() {
        return procurementDao.findAllPurchase();
    }

    @Override
    public List<PurchaseProductInfoPo> findPurchaseById(Integer purchaseOrderId) {
        return procurementDao.findPurchaseById(purchaseOrderId);
    }
    /**
     * 根据id插入采购价格价格
     * @param purchaseSubmitBo
     * @return
     */
    @Override
    public int insertPurchasePriceById(PurchaseSubmitBo purchaseSubmitBo) {
        List<PurchaseProductBo> purchaseProductList = purchaseSubmitBo.getPurchaseProductList();
        Integer purchaseOrderId = purchaseProductList.get(0).getPurchaseOrderId();
        int rows=0;
        PurchaseProductInfoPo purchaseProductInfoPo = new PurchaseProductInfoPo();
        for (PurchaseProductBo purchaseProductBo : purchaseProductList) {
            BeanUtils.copyProperties(purchaseProductBo,purchaseProductInfoPo);
            purchaseProductInfoPo.setSupplierName(purchaseSubmitBo.getSupplierName());
            purchaseProductInfoPo.setSupplierTel(purchaseSubmitBo.getSupplierTel());
            purchaseProductInfoPo.setSupplierNo(purchaseSubmitBo.getSupplierNo());
            rows+= procurementDao.insertPurchasePriceById(purchaseProductInfoPo);
        }
        //生成来料付款单
        FinancePo financePo = new FinancePo();
        financePo.setAmount(procurementDao.findSumPriceById(purchaseOrderId));
        financePo.setName(purchaseSubmitBo.getSupplierName());
        financePo.setOrderId(purchaseOrderId);
        financePo.setNo(purchaseSubmitBo.getSupplierNo());
        financePo.setTel(purchaseSubmitBo.getSupplierTel());
        procurementDao.insertFinance(financePo);
        //查询是否采购完成
        List<Double> purchasePriceByIdList = procurementDao.findPurchasePriceById(purchaseOrderId);
        if(purchasePriceByIdList.size()==0){
            procurementDao.purchaseOrderAccomplish(purchaseOrderId);
        }
        return rows;
    }
    /**
     * 查询采购单状态
     * @return
     */
    @Override
    public List<StockoutPurchaseVo> findAllStockoutPurchase(String purchaseSellName) {
        return procurementDao.findAllStockoutPurchase(purchaseSellName);
    }
}
