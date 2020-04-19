package com.puyin.cn.controller;

import com.puyin.cn.BO.AddProductBo;
import com.puyin.cn.BO.UpdataPrewarningValueBo;
import com.puyin.cn.dao.EpsProductDao;
import com.puyin.cn.entity.EpsProductInfoPo;
import com.puyin.cn.entity.Inbound;
import com.puyin.cn.service.EpsProductService;
import com.puyin.cn.vo.PermissionVo;
import com.puyin.cn.vo.WarehouseEnterVO;
import com.puyin.cn.vo.WarehouseOutInfo;
import com.puyin.cn.vo.WarehouseOutVo;
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
    public Double findEpsPrewarningById(Long productId){
        Double epsPrewarningById = epsProductService.findEpsPrewarningById(productId);
        if(epsPrewarningById==null){
            return 0.0;
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

    /**
     * 查询所有出库单
     * @return
     */
    @RequestMapping("findAllWarehouseOut")
    public List<WarehouseOutVo> findAllWarehouseOut(){
        return epsProductService.findAllWarehouseOut();
    }
    /**
     * 查询所有出库单详情
     * @return
     */
    @RequestMapping("finWarehouseOutInfoById")
    public List<WarehouseOutInfo> finWarehouseOutInfoById(Long id){
        return epsProductService.finWarehouseOutInfoById(id);
    }
    /**
     * 查询所有入库单
     * @return
     */
    @RequestMapping("finAllwarehuouseEnter")
    public List<WarehouseOutVo> finAllwarehuouseEnter(){
        return epsProductService.finAllwarehuouseEnter();

    }
    /**
     * 查询所有入库单详情
     * @return
     */
    @RequestMapping("finWarehouseEnterInfoById")
    public List<WarehouseEnterVO> finWarehouseEnterInfoById(Long id){
        return  epsProductService.finWarehouseEnterInfoById(id);
    }
    /**
     * 确定入库
     * @param warehouseEnterVO
     * @return
     */
   @RequestMapping("PutInStorge")
   public int PutInStorge(WarehouseEnterVO warehouseEnterVO){
       epsProductService.PutInStorge(warehouseEnterVO);
       return 0;
   }
    /**
     * 确定出库库
     * @param warehouseOutInfo
     * @return
     */
    @RequestMapping("PutOutStorge")
    public int PutOutStorge(WarehouseOutInfo warehouseOutInfo){
        epsProductService.PutOutStorge(warehouseOutInfo);
        return 0;
    }
    @RequestMapping("addProduct")
    public int addProduct(AddProductBo addProductBo){
        return epsProductService.addProductToStager(addProductBo);
    }

    /**
     * 添加类名
     * @param categoryName
     * @return
     */
    @RequestMapping("addCategoryName")
    public int addCategoryName(String categoryName){
        if (categoryName.isEmpty()){
            return 0;
        }else {
            return epsProductService.addCategoryName(categoryName);
        }
    }
}
