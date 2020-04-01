package com.puyin.cn.dao;

import com.puyin.cn.entity.CategroyPo;
import com.puyin.cn.entity.SalesPO;
import com.puyin.cn.entity.TemporaryPo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述：销售部
 *
 * @author PuYinsheng
 * @date 2020/3/30
 **/
@Repository
public interface SalesDao {
    List<SalesPO> findAllProduct();
    List<CategroyPo> findAllCateGroy();
    /**
     * 想临时表插入数据
     */
    int insertTemporary(TemporaryPo temporaryPo);
}
