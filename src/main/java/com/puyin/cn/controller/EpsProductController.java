package com.puyin.cn.controller;

import com.puyin.cn.BO.UpdataPrewarningValueBo;
import com.puyin.cn.entity.EpsProductInfoPo;
import com.puyin.cn.entity.Inbound;
import com.puyin.cn.service.EpsProductService;
import com.puyin.cn.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述：
 *
 * @author 仓库部
 * @date 2020/4/14
 **/
@RestController
public class EpsProductController {
    @Autowired
    private EpsProductService epsProductService;

    /**
     * 查询所有商品
     * @return
     */
    @RequestMapping("findAllEpsProduct")
    public List<EpsProductInfoPo> findAllEpsProduct(){
        return  epsProductService.findAllEpsProduct();
    }

    /**
     * 根据id修改货物预警值
     * @param updataPrewarningValueBo
     * @return
     */
    @RequestMapping("updateprewarningById")
    public Integer updateprewarningById(UpdataPrewarningValueBo updataPrewarningValueBo){
      return   epsProductService.updateprewarningById(updataPrewarningValueBo);
    }
    /**
     * 根据id修改货物预警值
     * @param productId
     * @return
     */
    @RequestMapping("findEpsPrewarningById")
    public Integer findEpsPrewarningById(Long productId){
        Integer epsPrewarningById = epsProductService.findEpsPrewarningById(productId);
        if(epsPrewarningById==null){
            return 0;
        }else{
            return epsPrewarningById;
        }
    }
    /**
     * 查询所有入库单
     * @return
     */
    @RequestMapping("findAllInbound")
    public List<Inbound> findAllInbound(){
        return epsProductService.findAllInbound();
    }
}
