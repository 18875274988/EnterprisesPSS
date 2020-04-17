package com.puyin.cn.service.serviceIpml;

import com.puyin.cn.BO.PurchaseProductBo;
import com.puyin.cn.BO.PurchaseSubmitBo;
import com.puyin.cn.dao.ProcurementDao;
import com.puyin.cn.entity.FinancePo;
import com.puyin.cn.entity.PurchaseOrderByIdPo;
import com.puyin.cn.entity.PurchaseProductInfoPo;
import com.puyin.cn.entity.WarehouseOrderInfoPo;
import com.puyin.cn.service.PurchaseService;
import com.puyin.cn.util.MyStringUtil;
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
     * 采购任务
     * @param purchaseSubmitBo
     * @return
     */
    @Override
    public int insertPurchasePriceById(PurchaseSubmitBo purchaseSubmitBo) {
        boolean checkClientNOresult = MyStringUtil.checkClientNO(purchaseSubmitBo.getSupplierNo());
        boolean checkClientTelresult = MyStringUtil.checkClientTel(purchaseSubmitBo.getSupplierTel());
        if (checkClientNOresult && checkClientTelresult){
        }else{
            return -2;
        }
        List<PurchaseProductBo> purchaseProductList = purchaseSubmitBo.getPurchaseProductList();
        if(purchaseProductList.size()==0){
            //防止下标越界
            return -3;
        }
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
        financePo.setAmount(procurementDao.findSumPriceById(purchaseSubmitBo.getSupplierName()));
        financePo.setName(purchaseSubmitBo.getSupplierName());
        financePo.setOrderId(purchaseOrderId);
        financePo.setNo(purchaseSubmitBo.getSupplierNo());
        financePo.setTel(purchaseSubmitBo.getSupplierTel());
        procurementDao.insertFinance(financePo);
        //查询是否采购完成
        List<Long> purchasePriceByIdList = procurementDao.findPurchasePriceById(purchaseOrderId);
        if(purchasePriceByIdList.size()==0){
            procurementDao.purchaseOrderAccomplish(purchaseOrderId);
            //生成入库单和待出库单
            addWarehouseOrder(purchaseOrderId.longValue());

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

    /**
     * 生成商品入库单
     * @param purchaseOrderId
     * @return
     */
    @Override
    public int addWarehouseOrder(Long purchaseOrderId) {
        //生成入库单编号
        String warehouseNo = "EPSWE"+MyStringUtil.getTimeToString();
        procurementDao.addWarehouseOrder(warehouseNo);
        Long warehouseOrderId = procurementDao.findWarehouseOrderIdByNo(warehouseNo);
        List<PurchaseOrderByIdPo> allPurchaseById = procurementDao.findAllPurchaseById(warehouseOrderId);
        for (PurchaseOrderByIdPo purchaseOrderByIdPo : allPurchaseById) {
            WarehouseOrderInfoPo warehouseOrderInfoPo = new WarehouseOrderInfoPo();
            warehouseOrderInfoPo.setWarehouseId(warehouseOrderId);
            //供应商信息
            String supplierInfo = "Name:"+purchaseOrderByIdPo.getSupplierName() +"Tel:"+ purchaseOrderByIdPo.getSupplierTel() + "No:"+purchaseOrderByIdPo.getSupplierNo();
            warehouseOrderInfoPo.setSupplierInfo(supplierInfo);
            warehouseOrderInfoPo.setProductPurchasePrice(purchaseOrderByIdPo.getProductPurchasePrice());
            warehouseOrderInfoPo.setProductName(purchaseOrderByIdPo.getProductName());
            warehouseOrderInfoPo.setProductCount(purchaseOrderByIdPo.getProductCount());
            procurementDao.insertWarehouseProduct(warehouseOrderInfoPo);
        }
        //生成待出库单
        //1.生成出库单单号
        String warehouseNoOut = MyStringUtil.getTimeToString();
        procurementDao.AddOutboundOrder(warehouseNoOut);
        //2.拿到出库单状态
        procurementDao.updatewarehouse(warehouseOrderId.intValue());
        //3.生成待出库单详情

        return 0;
    }
}
