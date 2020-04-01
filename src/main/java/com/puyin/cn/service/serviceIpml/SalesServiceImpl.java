package com.puyin.cn.service.serviceIpml;

import com.puyin.cn.dao.SalesDao;
import com.puyin.cn.entity.CategroyPo;
import com.puyin.cn.entity.SalesPO;
import com.puyin.cn.entity.TemporaryPo;
import com.puyin.cn.service.SalesService;
import com.puyin.cn.vo.SalesVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/30
 **/
@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesDao salesDao;

    /**
     * 查询所有商品
     * @return
     */
    @Override
    public List<SalesVo> findAllProduct() {
        List<SalesPO> allProduct = salesDao.findAllProduct();
        ArrayList<SalesVo> list = new ArrayList<>();
        for (SalesPO salesPO : allProduct) {
            SalesVo salesVo = new SalesVo();
            BeanUtils.copyProperties(salesPO,salesVo);
            list.add(salesVo);
        }
        return list;
    }

    /**
     * 查询所有商品种类
     * @return
     */
    @Override
    public List<CategroyPo> finfAllCategroy() {
        return salesDao.findAllCateGroy();
    }

    @Override
    public int intsertTemporary(TemporaryPo temporaryPo) {
        return salesDao.insertTemporary(temporaryPo);
    }
}
