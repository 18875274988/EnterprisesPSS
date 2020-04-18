package com.puyin.cn.dao;

import com.puyin.cn.BO.UpdataPrewarningValueBo;
import com.puyin.cn.entity.EpsProductInfoPo;
import com.puyin.cn.entity.Inbound;
import com.puyin.cn.entity.UpdataProductStateByIdPo;
import com.puyin.cn.vo.WarehouseEnterVO;
import com.puyin.cn.vo.WarehouseOutInfo;
import com.puyin.cn.vo.WarehouseOutVo;
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
     * @return
     */
    List<EpsProductInfoPo> findAllEpsProduct();
    /**
     * 根据id修改预警值
     * @param updataPrewarningValueBo
     * @return
     */
    Integer updateprewarningById(UpdataPrewarningValueBo updataPrewarningValueBo);
    /**
     *根据id修改状态
     * @param updataProductStateByIdPo
     * @return
     */
    Integer updataProductStateById(UpdataProductStateByIdPo updataProductStateByIdPo);
    /**
     *
     *根据id修改状态
     * @param updataProductStateByIdPo
     * @return
     */
    Integer updataProductStateByIdtwo(UpdataProductStateByIdPo updataProductStateByIdPo);

    /**
     * 根据ID查找商品库存
     * @param id
     * @return
     */
    String findProductCountById(Long id);

    /**
     * 根据id查询预警值
     * @param id
     * @return
     */
    Integer findEpsPrewarningById(Long id);

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
}
