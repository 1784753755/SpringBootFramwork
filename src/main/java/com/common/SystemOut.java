package com.common;
        /*
         * */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SystemOut {

    public static void show(String string) {
        System.out.println("显示：" + string);
    }

    public static void show(Integer integer) {
        System.out.println("显示：" + integer);
    }

    //匹配中文
    public static boolean RegEx(String getsString) {
        //Pattern pat = Pattern.compile("^[\u4E00-\u9FA5]{3}$");
        Pattern pat = Pattern.compile("^(\\d){0,}$");
        Matcher mat = pat.matcher(getsString);

        if (mat.matches()) {
            return true;
        }
        return false;
    }

}
