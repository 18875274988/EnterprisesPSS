package com.puyin.cn.controller;

import com.puyin.cn.BO.ClientInfoBo;
import com.puyin.cn.BO.SubmitOrderBo;
import com.puyin.cn.BO.TemporaryProductBo;
import com.puyin.cn.entity.CategroyPo;
import com.puyin.cn.entity.TemporaryPo;
import com.puyin.cn.service.SalesService;
import com.puyin.cn.util.MyStringUtil;
import com.puyin.cn.vo.SalesVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/30
 **/
@RestController
public class SalesController {
    @Autowired
    private SalesService salesService;

    @RequestMapping("findAllProduct")
    public List<SalesVo> findAllProduct(){
        return salesService.findAllProduct();
    }

    @RequestMapping("findAllCategroy")
    public List<CategroyPo> findAllCategroy(){
        return salesService.finfAllCategroy();
    }
    /**
     * 存储待下单临时货物信息
     */
    @PostMapping("insertTemporary")
    public int insertTemporary(@RequestBody List<TemporaryProductBo> temporaryProductBos){
        int rows=0;
        for (TemporaryProductBo temporaryProductBo : temporaryProductBos) {
            TemporaryPo temporaryPo = new TemporaryPo();
            BeanUtils.copyProperties(temporaryProductBo,temporaryPo);
             int row = salesService.intsertTemporary(temporaryPo);
            if (row==1){rows++;}
        }
        if (rows==temporaryProductBos.size()){
            return 1;
        }else {
            return 0;
        }

    }

    /**
     * 查询临时订单表
     * @param accountName
     * @return
     */
    @RequestMapping("selectTemporary")
    public List<TemporaryPo> selectTemporary(String accountName){
        return salesService.selectTemporary(accountName);
    }

    /**
     * 客户信息入参校验
     * @param clientInfoBo
     * @return
     */
    @RequestMapping("checkParameter")
    public int checkParameter(ClientInfoBo clientInfoBo){
        boolean checkClientNOresult = MyStringUtil.checkClientNO(clientInfoBo.getClientNo());
        boolean checkClientTelresult = MyStringUtil.checkClientTel(clientInfoBo.getClientTel());
        if (checkClientNOresult && checkClientTelresult){
            return 1;
        }else {
            return 0;
        }
    }

    /**
     * 销售部提交订单
     * @param submitOrderBo
     * @return
     */
    @PostMapping("startOrder")
    public int startOrder(@RequestBody SubmitOrderBo  submitOrderBo){
        int productCount = salesService.findProductCount(submitOrderBo);
        return productCount;
    }

}
