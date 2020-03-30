package com.puyin.cn.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/28
 **/
@Data
@Accessors(chain = true)
public class PermissionVo {
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private  String password;
    /**
     * 身份
     */
    private String identity;
}
