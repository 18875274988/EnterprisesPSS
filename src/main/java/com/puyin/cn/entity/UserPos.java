package com.puyin.cn.entity;

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
public class UserPos {
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
