package com.puyin.cn.controller;

import com.puyin.cn.service.PermissionService;
import com.puyin.cn.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/28
 * @copyright 2020 [图片]www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于北京天源迪科信息技术有限公司内部传阅，禁止外泄以及用于其他商业目的.
 **/
@RestController
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("findAlluser")
    public   List<PermissionVo> findAlluser(){
        List<PermissionVo> allUser = permissionService.findAllUser();
        return  allUser;
    }
    /**
     * 管理员授权
     */
    @RequestMapping("updateIdentity")
    public int updateIdentity(Integer id,Integer identity){
        return permissionService.updateIdentity(id,identity);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping("deleteUser")
    public int deleteUser(Integer id){
        return permissionService.deleteUser(id);
    }
}
