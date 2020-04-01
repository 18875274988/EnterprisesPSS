package com.puyin.cn.controller;

import com.puyin.cn.BO.TemporaryProduBo;
import com.puyin.cn.BO.TemporaryProduct;
import com.puyin.cn.entity.CategroyPo;
import com.puyin.cn.service.SalesService;
import com.puyin.cn.vo.SalesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public int insertTemporary(@RequestBody TemporaryProduBo temporaryProduBo){
        TemporaryProduBo temporaryProduBo1 = temporaryProduBo;
//        for (TemporaryProduct produBo : productList) {
//            TemporaryPo temporaryPo = new TemporaryPo();
//            BeanUtils.copyProperties(produBo, temporaryPo);
//            int row = salesService.intsertTemporary(temporaryPo);
//            if(row==1){rows++;}
//        }
//        if((productList.size()+1)==rows){
//            return 1;
//        }else {return 0;}
        return 0;
    }
}
