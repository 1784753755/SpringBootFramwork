package com.common;

import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class GetIp {
    public  static  String showCurrentIp(HttpServletRequest request){
         String ip = request.getHeader("x-forwarded-for");
          if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.equals("0:0:0:0:0:0:0:1")) {
            ip = "本地";
        }
       return ip;
    }

    public static String showCurrentUrl(HttpServletRequest request) {
       return request.getHeader("Referer");
      /*  String strBackUrl = "http://" + request.getServerName() + ":"
                + request.getServerPort()
                + request.getContextPath()
                + request.getServletPath()
                + "?" + (request.getQueryString());*/
    }
}
