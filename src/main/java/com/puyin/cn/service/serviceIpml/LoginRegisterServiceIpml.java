package com.puyin.cn.service.serviceIpml;

import com.puyin.cn.BO.LoginRegisterBo;
import com.puyin.cn.BO.RegisterBo;
import com.puyin.cn.BO.UpdatePassWordBo;
import com.puyin.cn.dao.LoginRegisterDao;
import com.puyin.cn.entity.UserPo;
import com.puyin.cn.service.LoginRegisterService;
import com.puyin.cn.vo.LoginRegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/27
 * @copyright 2020 [图片]www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于北京天源迪科信息技术有限公司内部传阅，禁止外泄以及用于其他商业目的.
 **/
@Service
public class LoginRegisterServiceIpml implements LoginRegisterService {
    @Autowired
    private LoginRegisterDao loginRegisterDao;
    /**
     * 登录验证
     * @param loginRegisterBo
     * @return
     */
    @Override
    public LoginRegisterVo findUser(LoginRegisterBo loginRegisterBo) {
        UserPo userPo = loginRegisterDao.findUser(loginRegisterBo.getUsername());
        LoginRegisterVo loginRegisterVo = new LoginRegisterVo();
        if (userPo==null){
            loginRegisterVo.setState(1).setIdentity("false");
            return loginRegisterVo;
        }
        if (loginRegisterBo.getPassword().equals(userPo.getPassword())){
            loginRegisterVo.setIdentity(userPo.getIdentity());
            if (userPo.getIdentity()==null){
                loginRegisterVo.setState(3);
            }else {
                loginRegisterVo.setState(0);
            }
        }else {
            loginRegisterVo.setState(1).setIdentity("false");
            return loginRegisterVo;
        }
        return  loginRegisterVo;
    }

    /**
     * 注册
     * @param registerBo
     * @return
     */
    @Override
    public LoginRegisterVo insertUser(RegisterBo registerBo) {
        int rows = loginRegisterDao.insertUser(registerBo);
        LoginRegisterVo loginRegisterVo = new LoginRegisterVo();
        loginRegisterVo.setState(rows);
        return  loginRegisterVo;
    }

    /**
     * 用户名查重
     * @param username
     * @return
     */
    @Override
    public LoginRegisterVo finduserByusername(String username) {
        Integer id = loginRegisterDao.finfUserByuerneme(username);
        LoginRegisterVo loginRegisterVo = new LoginRegisterVo();
        if (id!=null){
            loginRegisterVo.setState(1);
            return loginRegisterVo;
        }else {
           return loginRegisterVo.setState(0);

        }
    }

    /**
     * 修改密码
     * @param updatePassWordBo
     * @return
     */
    @Override
    public int UpdatePassWord(UpdatePassWordBo updatePassWordBo) {
        String password = loginRegisterDao.findPassword(updatePassWordBo.getUserName());
        if(updatePassWordBo.getNewPassword().equals(password)){
            return 1;
        }else {
            loginRegisterDao.UpdatePassWord(updatePassWordBo);
            return 0;
        }
    }
}
