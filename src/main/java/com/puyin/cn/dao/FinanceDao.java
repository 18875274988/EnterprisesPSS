package com.puyin.cn.dao;

import com.puyin.cn.entity.FinancePo;
import com.puyin.cn.vo.PaymentOrderInfoVo;
import com.puyin.cn.vo.SellOrderInfoVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述：财务部
 *
 * @author PuYinsheng
 * @date 2020/4/14
 **/
@Repository
public interface FinanceDao {
    /**
     * 查找说有代付款采购单
     * @return
     */
    List<FinancePo> findAllPaymentOrder();

    /**
     * 来料付款单付款
     * @param id
     * @return
     */
    int finishPaymentOrder(Long id);

    /**
     * 生成付款单结束时间
     * @param id
     * @return
     */
    int addEndTime(Long id);
    /**
     * 采购付款单详情页
     * @param orderId
     * @return
     */
    List<PaymentOrderInfoVo> findPurchaseProductList(Long orderId);

    /**
     * 查询所有待收款单
     * @return
     */
    List<FinancePo> findAllReceipt();

    /**
     *根据id查询待付款单详情
     * @param id
     * @return
     */
    List<SellOrderInfoVo> findOrderNoreceipt(Long id);

    /**
     * 收款完成调用
     * @param id
     * @return
     */
    int finishReceiptOrder(Long id);

    /**
     * 收款完成调用修改订单状态
     * @param id
     * @return
     */
   int updateSellOrderState(Long id);

    /**
     * 根据收款id查询订单id
     * @return
     */
   Long findSellOrderIdByFinanceId(Long id);
}
