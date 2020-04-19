package com.puyin.cn;

import com.puyin.cn.BO.PurchaseProductBo;
import com.puyin.cn.BO.UpdataPrewarningValueBo;
import com.puyin.cn.dao.EpsProductDao;
import com.puyin.cn.dao.ProcurementDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EnterprisesPssApplicationTests {
    @Autowired
    private EpsProductDao epsProductDao;
    @Test
    void contextLoads() {
        epsProductDao.findEpsPrewarningById(1L);
    }

}
