package com.puyin.cn.service.serviceIpml;

import com.puyin.cn.dao.EpsProductDao;
import com.puyin.cn.entity.EpsProductInfoPo;
import com.puyin.cn.service.EpsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：
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
}
