package com.puyin.cn.dao;

import com.puyin.cn.entity.FinancePo;
import com.puyin.cn.vo.PaymentOrderInfoVo;
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
     * 采购付款单详情页
     * @param orderId
     * @return
     */
    List<PaymentOrderInfoVo> findPurchaseProductList(Long orderId);
}
