package com.common;

import java.util.UUID;

public class RandomOrderNum {
    public static String makeOrderNum(){
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodev = UUID.randomUUID().toString().hashCode();
        System.out.println(UUID.randomUUID().toString());
        if(hashCodev < 0){
            //有可能是负数
            hashCodev = -hashCodev;
        }
        //"%015d"的意思：0代表不足位数的补0，这样可以确保相同的位数，15是位数也就是要得到到的字符串长度是15，d代表数字。
       String orderNum="LG"+machineId+hashCodev;
        return  orderNum;
    }


}