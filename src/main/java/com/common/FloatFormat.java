package com.common;

import java.text.DecimalFormat;

public class FloatFormat {
//    return format float2
    public  static  String  floatFormat(Float getFloat){
        DecimalFormat fnum  =   new  DecimalFormat("##0.00");
        String   dd=fnum.format(getFloat);
        return  dd;
    }
}
