package com.puyin.cn.dao;

import com.puyin.cn.entity.EpsProductInfoPo;
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
    List<EpsProductInfoPo> findAllEpsProduct();
}
