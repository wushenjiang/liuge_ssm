package com.liuge.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * @ClassName: DateUtils
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/6/20  19:32
 */
public class DateUtils {

    /**
     *  日期转换成字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String date2String(Date date,String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String format = simpleDateFormat.format(date);
        return format;
    }
    // 字符串转换成日期
    public static Date string2Date(String str,String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date parse = simpleDateFormat.parse(str);
        return parse;
    }
}
