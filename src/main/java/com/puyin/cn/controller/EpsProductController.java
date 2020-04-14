package com.puyin.cn.controller;

import com.puyin.cn.entity.EpsProductInfoPo;
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
 * @author
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
}
