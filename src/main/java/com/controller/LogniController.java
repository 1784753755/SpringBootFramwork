package com.controller;

import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Autor cai
 * @Date 2018/8/31
 * @LogginController 登入控制类*/

@RestController
public class LogniController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/verification.html")
    public  String   verificationUser(HttpServletRequest request){
            String    getName=  request.getParameter("admin");
            String   getPwd=  request.getParameter("pwd");
            if(getName==null||getPwd==null)
                return "账号密码为空";
          boolean getPast=loginService.verificate(getName,getPwd);
          if(getPast){
              return request.getContextPath()+"/index.html";
          }
          return "账号密码错误";

    }
    @RequestMapping("/quit.do")
   public  String  quitLog(HttpServletRequest request){
        request.getSession().invalidate();
        return "退出成功";
   }
}
