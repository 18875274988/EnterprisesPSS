package com.puyin.cn.service;

import com.puyin.cn.BO.UpdataPrewarningValueBo;
import com.puyin.cn.entity.EpsProductInfoPo;

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
    Integer findEpsPrewarningById(Long id);
}
