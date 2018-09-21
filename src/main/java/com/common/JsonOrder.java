package com.common;

import com.google.gson.Gson;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class JsonOrder {
    public static void main(String[] args) {
        saveJsonOrder("");
    }

    public static void saveJsonOrder(String getJsonOrder) {
        /*"g_id":"357","g_color":"rc1","g_package":"r1","g_name":"龙驹xxx111","g_price":40,"g_img":"/static/images/upload/addProduct/06c9c11a-ebad-4b18-82fd-228335c9f2c1.jpg","g_color_name":"丹红","g_package_name":"套餐1","num":"2"*/
        getJsonOrder = "[{\"g_id\":\"340\",\"g_color\":\"rc3\",\"g_package\":\"r1\",\"g_name\":\"淘气\",\"g_price\":13332,\"g_img\":\"/static/images/upload/addProduct/c3d74492-633e-4ff5-b262-a1c2ba59a838.jpg\",\"g_color_name\":\"14\",\"g_package_name\":\"套餐5\",\"num\":\"2\"},{\"g_id\":\"340\",\"g_color\":\"rc3\",\"g_package\":\"r1\",\"g_name\":\"淘气\",\"g_price\":13332,\"g_img\":\"/static/images/upload/addProduct/c3d74492-633e-4ff5-b262-a1c2ba59a838.jpg\",\"g_color_name\":\"14\",\"g_package_name\":\"套餐5\",\"num\":\"2\"},{\"g_id\":\"340\",\"g_color\":\"rc3\",\"g_package\":\"r1\",\"g_name\":\"淘气\",\"g_price\":13332,\"g_img\":\"/static/images/upload/addProduct/c3d74492-633e-4ff5-b262-a1c2ba59a838.jpg\",\"g_color_name\":\"14\",\"g_package_name\":\"套餐5\",\"num\":\"2\"},{\"g_id\":\"357\",\"g_color\":\"rc1\",\"g_package\":\"r1\",\"g_name\":\"龙驹xxx111\",\"g_price\":40,\"g_img\":\"/static/images/upload/addProduct/06c9c11a-ebad-4b18-82fd-228335c9f2c1.jpg\",\"g_color_name\":\"丹红\",\"g_package_name\":\"套餐1\",\"num\":\"2\"}]";
        String newOne = getJsonOrder.substring(getJsonOrder.indexOf('[') + 1, getJsonOrder.lastIndexOf(']'));

       String [] getIndex=newOne.split("},");
       StringBuffer stringBuffer;
       int i=0;
       for(String s :getIndex)
       {
           if(i<getIndex.length-1)
           {
               stringBuffer=new StringBuffer(s);
               stringBuffer.append("}");
               System.out.println("--"+i+"---"+stringBuffer.toString());
               delJson(stringBuffer.toString());
           }
           else{
               System.out.println(s);
               delJson(s);
           }

           i++;
       }


      /*  */

       /*
        String goodsid=(String) map.get("goods_id");
        System.out.println("map的值为:"+goodsid);*/
       //一个订单有多个明细 每个明细关系到每个产品


    }

  public static void  delJson(String s){
      System.out.println(s);
      Gson gson = new Gson();
      Map<String, Object> map = new Hashtable<>();
      map = gson.fromJson(s, map.getClass());
      Iterator<Map.Entry<String, Object>> it= map.entrySet().iterator();
      while (it.hasNext()) {
          Map.Entry<String, Object> entry = it.next();
          System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());

      }
    }
}
