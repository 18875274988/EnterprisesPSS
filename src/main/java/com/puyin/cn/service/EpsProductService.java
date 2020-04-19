package com.puyin.cn.service;

import com.puyin.cn.BO.AddProductBo;
import com.puyin.cn.BO.UpdataPrewarningValueBo;
import com.puyin.cn.entity.EpsProductInfoPo;
import com.puyin.cn.entity.Inbound;
import com.puyin.cn.vo.WarehouseEnterVO;
import com.puyin.cn.vo.WarehouseOutInfo;
import com.puyin.cn.vo.WarehouseOutVo;

import java.util.List;

/**
 * 描述：仓库部
 *
 * @author
 * @date 2020/4/14
 **/
public interface EpsProductService {
    /**
     * 查询所有货物信息
     * @return
     */
    List<EpsProductInfoPo> findAllEpsProduct();

    /**
     * 根据id修改货物信息
     * @param updataPrewarningValueBo
     * @return
     */
    Integer updateprewarningById(UpdataPrewarningValueBo updataPrewarningValueBo);
    /**
     * 根据id查询预警值
     * @param id
     * @return
     */
    Double findEpsPrewarningById(Long id);
    /**
     * 查询所有库单
     * @return
     */
    List<Inbound> findAllInbound();
    /**
     * 查询所有出库单
     * @return
     */
    List<WarehouseOutVo> findAllWarehouseOut();
    /**
     * 查询出库单详情(根据id)
     * @param id
     * @return
     */
    List<WarehouseOutInfo> finWarehouseOutInfoById(Long id);
    /**
     * 查询所有入库单
     * @return
     */
    List<WarehouseOutVo> finAllwarehuouseEnter();
    /**
     * 查询入库单详情
     * @param id 入库单id
     * @return
     */
    List<WarehouseEnterVO> finWarehouseEnterInfoById(Long id);

    /**
     * 确定入库
     * @param warehouseEnterVO
     * @return
     */
    int PutInStorge(WarehouseEnterVO warehouseEnterVO);

    /**
     * 确定出库
     * @param warehouseOutInfo
     * @return
     */
    int PutOutStorge(WarehouseOutInfo warehouseOutInfo);

    /**
     * 添加商品信息
     * @param addProductBo
     * @return
     */
    int addProductToStager(AddProductBo addProductBo);

    /**
     * 添加类目
     * @param categoryName
     * @return
     */
    int addCategoryName(String categoryName);
}
