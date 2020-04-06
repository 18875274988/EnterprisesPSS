package com.puyin.cn.service;

import com.puyin.cn.entity.CategroyPo;
import com.puyin.cn.entity.TemporaryPo;
import com.puyin.cn.vo.SalesVo;

import java.util.List;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/30
 **/
public interface SalesService {
    List<SalesVo> findAllProduct();
    List<CategroyPo> finfAllCategroy();
    /**
     * 向临时表插入待下单货物
     */
     int intsertTemporary(TemporaryPo temporaryPo);

    /**
     * 查询临时货物信息
     * @param name
     * @return
     */
     List<TemporaryPo> selectTemporary(String name);
}
