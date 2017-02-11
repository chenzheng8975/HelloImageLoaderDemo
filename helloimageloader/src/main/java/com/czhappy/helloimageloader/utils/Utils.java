package com.czhappy.helloimageloader.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Description:
 * User: chenzheng
 * Date: 2017/2/11 0011
 * Time: 11:11
 */
public class Utils {

    public static final DateFormat DATE_TIME_FORMATER = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss", Locale.CHINA);

    public static final DateFormat DATE_FORMATER = new SimpleDateFormat(
            "yyyy-MM-dd", Locale.CHINA);

    public static boolean isEmpty(String paramString) {
        return (paramString == null) || (paramString.trim().length() <= 0);
    }

}
