package com.common;

import javax.servlet.http.HttpServletRequest;

public class RequestSource {
    public static  boolean  isMobile(HttpServletRequest request){
        String requestHeader = request.getHeader("user-agent");
        if(isMobileDevice(requestHeader)){
            Log.showLog("使用手机浏览器");
            return true;
        }else{
            Log.showLog("使用web浏览器");
            return false;
        }
    }

    /**
     * android : 所有android设备
     * mac os : iphone ipad
     * windows phone:Nokia等windows系统的手机
     */
    public static boolean  isMobileDevice(String requestHeader){
        String[] deviceArray = new String[]{"android","mac os","windows phone"};
        if(requestHeader == null)
            return false;
        requestHeader = requestHeader.toLowerCase();
        for(int i=0;i<deviceArray.length;i++){
            if(requestHeader.indexOf(deviceArray[i])>0){
                return true;
            }
        }
        return false;
    }
    }
