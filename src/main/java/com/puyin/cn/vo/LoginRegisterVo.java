package com.puyin.cn.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/27
 * @copyright 2020 [图片]www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于北京天源迪科信息技术有限公司内部传阅，禁止外泄以及用于其他商业目的.
 **/
@Data
@Accessors(chain = true)
public class LoginRegisterVo {
    /**
     * 密码和有无身份校验
     */
    private Integer state;
    /**
     * 身份信息
     */
    private String identity;

}
