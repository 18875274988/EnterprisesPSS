package com.puyin.cn.BO;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 描述：登录入参
 *
 * @author PuYinsheng
 * @date 2020/3/27
 * @copyright 2020 [图片]www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于北京天源迪科信息技术有限公司内部传阅，禁止外泄以及用于其他商业目的.
 **/
@Data
@Accessors(chain = true)
public class LoginRegisterBo {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
