package com.puyin.cn.controller;

import com.puyin.cn.BO.LoginRegisterBo;
import com.puyin.cn.BO.RegisterBo;
import com.puyin.cn.BO.UpdatePassWordBo;
import com.puyin.cn.service.LoginRegisterService;
import com.puyin.cn.vo.LoginRegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/27
 * @copyright 2020 [图片]www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于北京天源迪科信息技术有限公司内部传阅，禁止外泄以及用于其他商业目的.
 **/
@RestController
public class LoginRegisterController {
    @Autowired
    private LoginRegisterService loginRegisterService;

    /**
     * 登录校验
     * @param loginRegisterBo
     * @return
     */
    @RequestMapping("findUser")
    public LoginRegisterVo findUser(LoginRegisterBo loginRegisterBo){
        if((loginRegisterBo.getPassword()!=null) &&(loginRegisterBo.getUsername()!=null)){
            LoginRegisterVo loginRegisterVo = loginRegisterService.findUser(loginRegisterBo);
            return loginRegisterVo;
        }else {
            LoginRegisterVo loginRegisterVo = new LoginRegisterVo();
            loginRegisterVo.setState(0).setIdentity("");
            return  loginRegisterVo;
        }

    }
    @RequestMapping("insertUser")
    public LoginRegisterVo insertUser(RegisterBo registerBo) {
        return loginRegisterService.insertUser(registerBo);
    }
    @RequestMapping("finduserByusrname")
    public LoginRegisterVo finduserByusrname(String username) {
        if (username==null || username.equals("")){
            LoginRegisterVo loginRegisterVo = new LoginRegisterVo();
            loginRegisterVo.setState(0);
            return loginRegisterVo;
        }
        LoginRegisterVo loginRegisterVo = loginRegisterService.finduserByusername(username);
        return loginRegisterVo;
    }

    /**
     * 修改密码
     * @param updatePassWordBo
     * @return
     */
    @RequestMapping("UpdatePassword")
    public int UpdatePassWord(UpdatePassWordBo updatePassWordBo){
        return loginRegisterService.UpdatePassWord(updatePassWordBo);
    }
}
