package com.puyin.cn.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/30
 **/
public class MyStringUtil {
    public static Double SubStringNumber(String str){
        String regEx = "[^(([1-9]\\d*)|0)(\\.\\d{1-2})?$]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        String result = m.replaceAll("").trim();
        double resultDouble = Double.parseDouble(result);
        return resultDouble;
    }
}
