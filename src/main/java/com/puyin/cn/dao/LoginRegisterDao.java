package com.puyin.cn.dao;

import com.puyin.cn.BO.RegisterBo;
import com.puyin.cn.BO.UpdatePassWordBo;
import com.puyin.cn.entity.UserPo;
import org.springframework.stereotype.Repository;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/27
 * @copyright 2020 [图片]www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于北京天源迪科信息技术有限公司内部传阅，禁止外泄以及用于其他商业目的.
 **/
@Repository
public interface LoginRegisterDao {
    UserPo findUser(String username);
    int insertUser(RegisterBo registerBo);
    Integer finfUserByuerneme(String username);

    /**
     * 修改密码
     * @param updatePassWordBo
     * @return
     */
    int UpdatePassWord (UpdatePassWordBo updatePassWordBo);

    /**
     * 根据用户名查询密码
     * @param userName
     * @return
     */
    String findPassword(String userName);
}
