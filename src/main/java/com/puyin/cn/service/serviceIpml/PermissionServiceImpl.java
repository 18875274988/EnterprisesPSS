package com.puyin.cn.service.serviceIpml;

import com.puyin.cn.dao.PermissionDao;
import com.puyin.cn.entity.UserPo;
import com.puyin.cn.entity.UserPos;
import com.puyin.cn.service.PermissionService;
import com.puyin.cn.vo.PermissionVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/28
 * @copyright 2020 [图片]www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于北京天源迪科信息技术有限公司内部传阅，禁止外泄以及用于其他商业目的.
 **/
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    /**
     * 查询所有用户
     * 管理员用户除外
     * @return
     */
    @Override
    public List<PermissionVo> findAllUser() {
        ArrayList<PermissionVo> permissionVos = new ArrayList<>();
        List<UserPos> alluser = permissionDao.findAlluser();
        for (UserPos userPos : alluser) {
            PermissionVo permissionVo = new PermissionVo();
            BeanUtils.copyProperties(userPos,permissionVo);
            permissionVos.add(permissionVo);
        }
        return permissionVos;
    }

    /**
     *
     * 管理员授权
     * @param id
     * @param identity
     * @return
     */
    @Override
    public int updateIdentity(Integer id, Integer identity) {
        return permissionDao.updateIdentity(id,identity);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public int deleteUser(Integer id) {
        return permissionDao.deleteUser(id);
    }
}
