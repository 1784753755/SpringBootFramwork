package com.common;

public class Transform {
/*
*  transform into Integer
* */
    public static  Integer getTransform(String input){
        Integer outPut=input==null?null:Integer.valueOf(input);
         return outPut;
    }
    /*
     *  transform into String
     * */
    public static  String getTransform(Integer input){
        String outPut=input==null?null:String.valueOf(input);
        return outPut;
    }
}
