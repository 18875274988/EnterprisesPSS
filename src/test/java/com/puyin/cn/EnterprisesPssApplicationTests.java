package com.puyin.cn;

import com.puyin.cn.BO.PurchaseSubmitBo;
import com.puyin.cn.dao.ProcurementDao;
import com.puyin.cn.dao.SalesDao;
import com.puyin.cn.entity.CommodityStocksPo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EnterprisesPssApplicationTests {
    @Autowired
    private ProcurementDao procurementDao;
    @Test
    void contextLoads() {
        PurchaseSubmitBo purchaseSubmitBo = new PurchaseSubmitBo();
        purchaseSubmitBo.setPurchaseOrderId(31);
        purchaseSubmitBo.setProductName("黄瓜");
        purchaseSubmitBo.setProductPurchasePrice(3.1415926);
        procurementDao.insertPurchasePriceById(purchaseSubmitBo);
    }

}
