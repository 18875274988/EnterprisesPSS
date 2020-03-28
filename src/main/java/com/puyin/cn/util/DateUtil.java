package com.puyin.cn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/24
 * @copyright 2020 [图片]www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于北京天源迪科信息技术有限公司内部传阅，禁止外泄以及用于其他商业目的.
 **/
public class DateUtil {
    public static String DateFormat(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String getstr = simpleDateFormat.format(date);
        return  getstr;
    }
    public static Date stringTOdate(String stringDate) throws ParseException {

        Date date = new SimpleDateFormat("yyyy/MM/dd").parse(stringDate);
        return date;
    }
}
