package com.puyin.cn.service.serviceIpml;

import com.puyin.cn.BO.AddProductBo;
import com.puyin.cn.BO.UpdataPrewarningValueBo;
import com.puyin.cn.dao.EpsProductDao;
import com.puyin.cn.entity.EpsProductInfoPo;
import com.puyin.cn.entity.Inbound;
import com.puyin.cn.entity.UpdataProductStateByIdPo;
import com.puyin.cn.service.EpsProductService;
import com.puyin.cn.util.MyStringUtil;
import com.puyin.cn.vo.WarehouseEnterVO;
import com.puyin.cn.vo.WarehouseOutInfo;
import com.puyin.cn.vo.WarehouseOutVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 描述：仓库部
 *
 * @author
 * @date 2020/4/14
 **/
@Service
public class EpsProductServiceImpl implements EpsProductService {
    @Autowired
    private EpsProductDao epsProductDao;
    @Override
    public List<EpsProductInfoPo> findAllEpsProduct() {
        return epsProductDao.findAllEpsProduct();
    }

    /**
     * 根据id修改货物预警值
     * @param updataPrewarningValueBo
     * @return
     */
    @Override
    public Integer updateprewarningById(UpdataPrewarningValueBo updataPrewarningValueBo) {
        Double prewarningValue = updataPrewarningValueBo.getPrewarningValue();
        Integer rows = epsProductDao.updateprewarningById(updataPrewarningValueBo);
        String productCountstr = epsProductDao.findProductCountById(updataPrewarningValueBo.getProductId());
        Double productCount = MyStringUtil.SubStringNumber(productCountstr);
        UpdataProductStateByIdPo updataProductStateByIdPo = new UpdataProductStateByIdPo();
       updataProductStateByIdPo.setProductCount(productCount);
       updataProductStateByIdPo.setProductId(updataPrewarningValueBo.getProductId());
       if(prewarningValue>productCount){
           epsProductDao.updataProductStateById(updataPrewarningValueBo.getProductId());
       }else {
           epsProductDao.updataProductStateByIdtwo(updataPrewarningValueBo.getProductId());
       }
        return rows;
    }
    /**
     * 根据id查询预警值
     * @param id
     * @return
     */
    @Override
    public Double findEpsPrewarningById(Long id) {
        return epsProductDao.findEpsPrewarningById(id);
    }
    /**
     * 查询所有库单
     * @return
     */
    @Override
    public List<Inbound> findAllInbound() {
        return epsProductDao.findAllInbound();
    }

    @Override
    public List<WarehouseOutVo> findAllWarehouseOut() {
        return epsProductDao.findAllWarehouseOut();
    }

    @Override
    public List<WarehouseOutInfo> finWarehouseOutInfoById(Long id) {
        return epsProductDao.finWarehouseOutInfoById(id);
    }

    @Override
    public List<WarehouseOutVo> finAllwarehuouseEnter() {
        return epsProductDao.finAllwarehuouseEnter();
    }

    @Override
    public List<WarehouseEnterVO> finWarehouseEnterInfoById(Long id) {
        return epsProductDao.finWarehouseEnterInfoById(id);
    }
    /**
     * 确定入库
     * @param warehouseEnterVO
     * @return
     */
    @Override
    public int PutInStorge(WarehouseEnterVO warehouseEnterVO) {
        //截取供货商信息姓名电话
        String supplierInfo = warehouseEnterVO.getSupplierInfo();
        String[] split = supplierInfo.split(":");
        String name = split[1].substring(0, split[1].indexOf("T"));
        String Tel = split[2].substring(0, split[2].indexOf("N"));
        warehouseEnterVO.setSupplierInfo(name+Tel);
        //根据商品名查询库存
        String productCountByName = epsProductDao.findProductCountByName(warehouseEnterVO.getProductName());
        //提取库存量
        BigDecimal count1 = new BigDecimal(MyStringUtil.SubStringNumber(productCountByName));
        //获取入库量
        BigDecimal count2 = new BigDecimal(MyStringUtil.SubStringNumber(warehouseEnterVO.getProductCount()));
        double count = count1.add(count2).doubleValue();
        //获取单位
        String unit = MyStringUtil.subStringStr(productCountByName);
        warehouseEnterVO.setProductCount(count+unit);
        //将商品插入数据库
        epsProductDao.addProduct(warehouseEnterVO);
        //检查预警状态
        //查询该商品id从而查询预警值
        Long idbyName = epsProductDao.findIdbyName(warehouseEnterVO.getProductName());
        Double epsPrewarningById = findEpsPrewarningById(idbyName);
        updatePrewrningStaeAndUpdateWarehouse(count,warehouseEnterVO);
        //如果入库单没有商品存在删除入库单
        if(finWarehouseEnterInfoById(warehouseEnterVO.getWarehouseId()).size()==0){
            epsProductDao.deleWarenouseOrder(warehouseEnterVO.getWarehouseId());
        }
        //修改待出单状态
        epsProductDao.outboundWarehouseOUtState(warehouseEnterVO.getWarehouseId());
        return 0;
    }

    /**
     * 确定出库
     * @param warehouseOutInfo
     * @return
     */
    @Override
    public int PutOutStorge(WarehouseOutInfo warehouseOutInfo) {
        //根据商品名查询商品库存
        String productCountByName = epsProductDao.findProductCountByName(warehouseOutInfo.getProductName());
        //准备调用入库数据层
        WarehouseEnterVO warehouseEnterVO = new WarehouseEnterVO();
        //提取库存量
        BigDecimal count1 = new BigDecimal(MyStringUtil.SubStringNumber(productCountByName));
        //获取出库量
        BigDecimal count2 = new BigDecimal(MyStringUtil.SubStringNumber(warehouseOutInfo.getProductCount()));
        double count = count1.subtract(count2).doubleValue();
        //获取单位
        String unit = MyStringUtil.subStringStr(productCountByName);
        warehouseOutInfo.setProductCount(count+unit);
        BeanUtils.copyProperties(warehouseOutInfo,warehouseEnterVO);
        //商品出库
        epsProductDao.addProducttwo(warehouseEnterVO);
        //查询该商品id从而查询预警值
        updatePrewrningStaeAndUpdateWarehouse(count,warehouseEnterVO);
        //如果入库单没有商品存在删除入库单
        if(finWarehouseOutInfoById(warehouseEnterVO.getWarehouseId()).size()==0){
            epsProductDao.deleWarenouseOrder(warehouseEnterVO.getWarehouseId());
        }
        return 0;
    }

    /**
     * 添加商品信息
     * @param addProductBo
     * @return
     */
    @Override
    public int addProductToStager(AddProductBo addProductBo) {
        //校验入参
        if(checkParm(addProductBo)){
            //插入数据库
           return  epsProductDao.addProductToStager(addProductBo);
        }else{
            return 0;
        }
    }

    /**
     * 添加类目
     * @param categoryName
     * @return
     */
    @Override
    public int addCategoryName(String categoryName) {
        return epsProductDao.addCategoryName(categoryName);
    }

    /**
     * 完成出入库并操作预警状态
     * @param count
     * @param warehouseEnterVO
     */
    public void updatePrewrningStaeAndUpdateWarehouse(Double count,WarehouseEnterVO warehouseEnterVO ){
        Long idbyName = epsProductDao.findIdbyName(warehouseEnterVO.getProductName());
        Double epsPrewarningById = findEpsPrewarningById(idbyName);
        //如果没有预警值
        if(epsPrewarningById==null){}
        else {
            //有预警值
            if(epsPrewarningById>count){
                epsProductDao.updataProductStateById(idbyName);
            }else {
                epsProductDao.updataProductStateByIdtwo(idbyName);
            }
        }
        //将已入库商品移除出库单
        epsProductDao.deleteByWarehouseEnterName(warehouseEnterVO.getProductName(),warehouseEnterVO.getWarehouseId());
    }

    /**
     * 添加商品入参校验
     * @param addProductBo
     * @return
     */
    boolean checkParm(AddProductBo addProductBo){
        boolean getProductCategory = addProductBo.getProductCategory().isEmpty();
        boolean getProductCount = addProductBo.getProductCount().isEmpty();
        boolean getProductName = addProductBo.getProductName().isEmpty();
        boolean getProductPurchasePrice = addProductBo.getProductPurchasePrice().isEmpty();
        boolean getProductFrom = addProductBo.getProductFrom().isEmpty();
        Double productPurchasePrice = MyStringUtil.SubStringNumber(addProductBo.getProductPurchasePrice());
        addProductBo.setProductPurchasePriceValue(productPurchasePrice);
        if(getProductCategory && getProductCount &&getProductName &&getProductPurchasePrice &&getProductFrom){
            return false;
        }
        return true;
    }
}
