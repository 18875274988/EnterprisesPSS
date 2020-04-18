package com.puyin.cn.dao;

import com.puyin.cn.entity.*;
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
    List<SalesOrderProductPO> findAllProduct();
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

    /**
     * 生成销售单
     * @param sellOrderPo
     * @return
     */
    int addSellOrder(SellOrderPo sellOrderPo);

    /**
     * 根据销售单编号查id
     * @param orderNo
     * @return
     */
    Long findIdByNo(String orderNo);

    /**
     * 生成销售单客户详情表
     * @param sellOrderFromInfoPo
     * @return
     */
    int addSellOrderFromInfo(SellOrderFromInfoPo sellOrderFromInfoPo);

    /**
     * 插入销售单货物详情
     * @param list
     * @return
     */
    int addSellOrderProductInfo(@Param("list") List<SellOrderProductInfo> list);

    /**
     * 生成收款单
     * @param financePo
     * @return
     */
    int addReceipt(FinancePo financePo);

}
