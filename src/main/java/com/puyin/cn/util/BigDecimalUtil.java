package com.puyin.cn.util;

import java.math.BigDecimal;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/24
 * @copyright 2020 [图片]www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于北京天源迪科信息技术有限公司内部传阅，禁止外泄以及用于其他商业目的.
 **/
public class BigDecimalUtil {
    public static String bigDecimaltoString(BigDecimal bigDecimal){
        //转化为字符串输出
        String OutString=bigDecimal.toString();
        return  OutString;
    }

    public static BigDecimal StringtoBigDecimal(String string){
        BigDecimal OutBigDecimal1=new BigDecimal(string);
        //设置小数位数，第一个变量是小数位数，第二个变量是取舍方法(四舍五入)
        OutBigDecimal1=OutBigDecimal1.setScale(2, BigDecimal.ROUND_HALF_UP);
        return OutBigDecimal1;
    }
}
