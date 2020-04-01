package com.puyin.cn.controller;

import com.puyin.cn.BO.TemporaryProductBo;
import com.puyin.cn.entity.CategroyPo;
import com.puyin.cn.entity.TemporaryPo;
import com.puyin.cn.service.SalesService;
import com.puyin.cn.vo.SalesVo;
import org.springframework.beans.BeanUtils;
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
    public int insertTemporary(@RequestBody List<TemporaryProductBo> temporaryProductBos){
        List<TemporaryProductBo> temporaryProductBos1 = temporaryProductBos;
        int row=0;
        for (TemporaryProductBo temporaryProductBo : temporaryProductBos) {
            TemporaryPo temporaryPo = new TemporaryPo();
            BeanUtils.copyProperties(temporaryProductBo,temporaryPo);
            row = salesService.intsertTemporary(temporaryPo);
            if(row==1){row++;}
        }
        if(row==temporaryProductBos.size()) {
            return 1;
        }else {
            return 0;
        }

    }
}
