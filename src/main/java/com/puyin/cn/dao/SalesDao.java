package com.puyin.cn.dao;

import com.puyin.cn.entity.CategroyPo;
import com.puyin.cn.entity.CommodityStocksPo;
import com.puyin.cn.entity.SalesPO;
import com.puyin.cn.entity.TemporaryPo;
import org.apache.ibatis.annotations.Param;
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
    /**
     * 查询临时订单信息
     */
    List<TemporaryPo> selectTemporary(String accountName);
    /**
     * 删除临时订单信息
     */
    int deleteTemporary(String accountName);
    /**
     * 查询销售部提交商品库存
     */
    List<CommodityStocksPo> findProductCount(@Param("ids")List<Integer> ids);

    /**
     * 根据id查询商品名
     * @param id
     * @return
     */
    String  findProductNameById(Integer id);

}
