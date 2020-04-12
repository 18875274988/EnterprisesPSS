package com.puyin.cn.util;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/30
 **/
public class MyStringUtil {
    /**
     * 提取字符串里的数字返回double
     * @param str
     * @return
     */
    public static Double SubStringNumber(String str){
        String regEx = "[^(([1-9]\\d*)|0)(\\.\\d{1-2})?$]";
        Pattern p = compile(regEx);
        Matcher m = p.matcher(str);
        String result = m.replaceAll("").trim();
        double resultDouble = Double.parseDouble(result);
        return resultDouble;
    }
    public static boolean checkClientTel(String tel){
        Pattern p = compile("0?(13|14|15|17|18|19)[0-9]{9}");
        Matcher m = p.matcher(tel);
        if (!m.matches()){
            return false;
        }
        return true;
    }
    public static boolean checkClientNO(String No){
        Pattern p = compile("\\d{17}[\\d|x]|\\d{15}");
        Matcher m = p.matcher(No);
        if (!m.matches()){
            return false;
        }
        return true;
    }

    /**
     * 过滤数字字符
     * @param str
     * @return
     */
    public static String subStringStr(String str) {
        str = str.replaceAll("([1-9]+[0-9]*|0)(\\\\.[\\\\d]+)?", "");

        return str;
    }

    /**
     * 获取当前时间到毫秒将数字转为字符串
     * @return
     */
    public static String getTimeToString(){
        Date date = Calendar.getInstance().getTime();
        String datedtr = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(date);
        String dateresult="";
        for (int i = 0; i < datedtr.length(); i++) {
            if (datedtr.charAt(i) >= 48 && datedtr.charAt(i) <= 57) {
                dateresult += datedtr.charAt(i);
            }
        }
        return dateresult;
    }
}
