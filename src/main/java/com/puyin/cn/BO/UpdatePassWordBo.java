package com.puyin.cn.BO;

import lombok.Data;

/**
 * 描述：修改密码入参
 *
 * @author PuYinsheng
 * @date 2020/4/18
 **/
@Data
public class UpdatePassWordBo {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 老密码
     */
    private String oldPassword;
    /**
     * 新密码
     */
    private String newPassword;

}
