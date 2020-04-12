package com.puyin.cn.service.serviceIpml;

import com.puyin.cn.BO.PurchaseSubmitBo;
import com.puyin.cn.dao.ProcurementDao;
import com.puyin.cn.entity.PurchaseProductInfoPo;
import com.puyin.cn.service.PurchaseService;
import com.puyin.cn.vo.PurchaseVo;
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
     * @param purchaseSubmitBos
     * @return
     */
    @Override
    public int insertPurchasePriceById(List<PurchaseSubmitBo> purchaseSubmitBos) {
        int rows=0;
        for (PurchaseSubmitBo purchaseSubmitBo : purchaseSubmitBos) {
            rows+= procurementDao.insertPurchasePriceById(purchaseSubmitBo);
        }
        return rows;
    }
}
