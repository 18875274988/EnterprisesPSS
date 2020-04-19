package com.puyin.cn.service;

import com.puyin.cn.BO.LoginRegisterBo;
import com.puyin.cn.BO.RegisterBo;
import com.puyin.cn.BO.UpdatePassWordBo;
import com.puyin.cn.entity.UserPo;
import com.puyin.cn.vo.LoginRegisterVo;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/27
 * @copyright 2020 [图片]www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于北京天源迪科信息技术有限公司内部传阅，禁止外泄以及用于其他商业目的.
 **/
public interface LoginRegisterService {
    LoginRegisterVo findUser(LoginRegisterBo loginRegisterBo);
    LoginRegisterVo insertUser(RegisterBo registerBo);
    LoginRegisterVo finduserByusername(String username);

    /**
     * 修改密码
     * @param updatePassWordBo
     * @return
     */
    int UpdatePassWord(UpdatePassWordBo updatePassWordBo);
}
