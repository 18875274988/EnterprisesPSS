package com.puyin.cn;

import com.puyin.cn.BO.PurchaseProductBo;
import com.puyin.cn.dao.ProcurementDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EnterprisesPssApplicationTests {
    @Autowired
    private ProcurementDao procurementDao;
    @Test
    void contextLoads() {
        PurchaseProductBo purchaseSubmitBo = new PurchaseProductBo();
        purchaseSubmitBo.setPurchaseOrderId(31);
        purchaseSubmitBo.setProductName("黄瓜");
        purchaseSubmitBo.setProductPurchasePrice(3.1415926);
    }

}
