package com.puyin.cn.service.serviceIpml;

import com.puyin.cn.dao.FinanceDao;
import com.puyin.cn.entity.FinancePo;
import com.puyin.cn.service.FinanceService;
import com.puyin.cn.util.MyStringUtil;
import com.puyin.cn.vo.PaymentOrderInfoVo;
import com.puyin.cn.vo.SellOrderInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 描述：财务部
 *
 * @author PuYinsheng
 * @date 2020/4/14
 **/
@Service
public class FinanceServiceImpl implements FinanceService {
    @Autowired
    private FinanceDao financeDao;
    @Override
    public List<FinancePo> findAllPaymentOrder() {
        return financeDao.findAllPaymentOrder();
    }

    /**
     * 来料付款单完成付款
     * @param id
     * @return
     */
    @Override
    public int finishPaymentOrder(Long id) {
        financeDao.addEndTime(id);
        return financeDao.finishPaymentOrder(id);
    }
    /**
     * 采购付款单详情页
     * @param orderId
     * @return
     */
    @Override
    public List<PaymentOrderInfoVo> findPurchaseProductList(Long orderId) {
        List<PaymentOrderInfoVo> purchaseProductList = financeDao.findPurchaseProductList(orderId);
        for (PaymentOrderInfoVo paymentOrderInfoVo : purchaseProductList) {
            Double count = MyStringUtil.SubStringNumber(paymentOrderInfoVo.getProductCount());
            BigDecimal countbigDecimal = new BigDecimal(count.doubleValue());
            BigDecimal pricebigDecimal = new BigDecimal((paymentOrderInfoVo.getProductPurchasePrice()).doubleValue());
            paymentOrderInfoVo.setSubTotal((countbigDecimal.multiply(pricebigDecimal)).doubleValue());
        }
        return purchaseProductList;
    }

    @Override
    public List<FinancePo> findAllReceipt() {
        return financeDao.findAllReceipt();
    }

    @Override
    public List<SellOrderInfoVo> findOrderNoreceipt(Long id) {
        List<SellOrderInfoVo> orderNoreceipt = financeDao.findOrderNoreceipt(id);
        //计算商品小计
        for (SellOrderInfoVo sellOrderInfoVo : orderNoreceipt) {
            BigDecimal count = BigDecimal.valueOf(Double.valueOf(sellOrderInfoVo.getProductCount()));
            BigDecimal price = BigDecimal.valueOf(sellOrderInfoVo.getProductPrice());
            Double total = count.multiply(price).doubleValue();
            sellOrderInfoVo.setProductTotal(total);
        }
        return orderNoreceipt;
    }

    @Override
    public int finishReceiptOrder(Long id) {
        return financeDao.finishReceiptOrder(id);
    }
}
