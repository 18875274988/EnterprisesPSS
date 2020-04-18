package com.puyin.cn.service.serviceIpml;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Integer rows = epsProductDao.updateprewarningById(updataPrewarningValueBo);
        String productCountstr = epsProductDao.findProductCountById(updataPrewarningValueBo.getProductId());
        Double productCount = MyStringUtil.SubStringNumber(productCountstr);
        UpdataProductStateByIdPo updataProductStateByIdPo = new UpdataProductStateByIdPo();
       updataProductStateByIdPo.setProductCount(productCount);
       updataProductStateByIdPo.setProductId(updataPrewarningValueBo.getProductId());
        epsProductDao.updataProductStateById(updataProductStateByIdPo);
        epsProductDao.updataProductStateByIdtwo(updataProductStateByIdPo);
        return rows;
    }
    /**
     * 根据id查询预警值
     * @param id
     * @return
     */
    @Override
    public Integer findEpsPrewarningById(Long id) {
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
}
