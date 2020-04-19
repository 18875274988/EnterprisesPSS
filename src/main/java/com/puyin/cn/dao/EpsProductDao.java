package com.puyin.cn.dao;

import com.puyin.cn.BO.AddProductBo;
import com.puyin.cn.BO.UpdataPrewarningValueBo;
import com.puyin.cn.entity.EpsProductInfoPo;
import com.puyin.cn.entity.Inbound;
import com.puyin.cn.entity.UpdataProductStateByIdPo;
import com.puyin.cn.vo.WarehouseEnterVO;
import com.puyin.cn.vo.WarehouseOutInfo;
import com.puyin.cn.vo.WarehouseOutVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述：
 *
 * @author
 * @date 2020/4/14
 **/
@Repository
public interface EpsProductDao {
    /**
     * 查询所有货物信息
     *
     * @return
     */
    List<EpsProductInfoPo> findAllEpsProduct();

    /**
     * 根据id修改预警值
     *
     * @param updataPrewarningValueBo
     * @return
     */
    Integer updateprewarningById(UpdataPrewarningValueBo updataPrewarningValueBo);

    /**
     * 根据id修改预警状态
     *
     * @param productId
     * @return
     */
    Integer updataProductStateById(Long productId);

    /**
     * 根据id修改预警状态
     *
     * @param productId
     * @return
     */
    Integer updataProductStateByIdtwo(Long productId);

    /**
     * 根据ID查找商品库存
     *
     * @param id
     * @return
     */
    String findProductCountById(Long id);

    /**
     * 根据id查询预警值
     *
     * @param id
     * @return
     */
    Double findEpsPrewarningById(Long id);

    /**
     * 查询所有库单
     *
     * @return
     */
    List<Inbound> findAllInbound();

    /**
     * 查询所有出库单
     *
     * @return
     */
    List<WarehouseOutVo> findAllWarehouseOut();

    /**
     * 查询出库单详情(根据id)
     *
     * @param id
     * @return
     */
    List<WarehouseOutInfo> finWarehouseOutInfoById(Long id);

    /**
     * 查询所有入库单
     *
     * @return
     */
    List<WarehouseOutVo> finAllwarehuouseEnter();

    /**
     * 查询入库单详情
     *
     * @param id 入库单id
     * @return
     */
    List<WarehouseEnterVO> finWarehouseEnterInfoById(Long id);

    /**
     * 根据商品名查询库存
     *
     * @param productName
     * @return
     */
    String findProductCountByName(String productName);

    /**
     * 商品入库
     *
     * @param warehouseEnterVO
     * @return
     */
    int addProduct(WarehouseEnterVO warehouseEnterVO);

    /**
     * 商品出库
     *
     * @param warehouseEnterVO
     * @return
     */
    int addProducttwo(WarehouseEnterVO warehouseEnterVO);

    /**
     * 根据商品名查询id
     *
     * @param productName
     * @return
     */
    Long findIdbyName(String productName);

    /**
     * 根据入库id修改待出库单状态
     *
     * @param id
     * @return
     */
    int outboundWarehouseOUtState(Long id);

    /**
     * 根据商品名删除入出库单商品
     *
     * @param productName
     * @param id
     * @return
     */
    int deleteByWarehouseEnterName(@Param("productName") String productName, @Param("id") Long id);

    /**
     * 根据id删除入出库单
     *
     * @param id
     * @return
     */
    int deleWarenouseOrder(Long id);

    /**
     * 添加商品
     *
     * @param addProductBo
     * @return
     */
    int addProductToStager(AddProductBo addProductBo);

    /**
     * 添加类目
     *
     * @param categoryName
     * @return
     */
    int addCategoryName(String categoryName);
}
