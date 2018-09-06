package com.common;

public class Current {
    /* StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();*/
    public static void currentLine( StackTraceElement[] stackTrace ){

        for(StackTraceElement s : stackTrace){
            System.out.println("----- 当前方法名字：" + s.getMethodName() + ""
                    + " , 当前代码是第几行：" + s.getLineNumber() + "------" );
        }
    }



}
