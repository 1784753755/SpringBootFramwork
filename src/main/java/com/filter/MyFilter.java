package com.filter;

import com.common.GetIp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyFilter implements Filter {
     public static Logger logger = LogManager.getLogger(MyFilter.class);
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    String[] url = new String[]{"/index.html", "/login.html", "/static/*", "/lib/*","/verification.html"};

    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest request = (HttpServletRequest) srequest;
        HttpServletResponse response = (HttpServletResponse) sresponse;
        String FilterUrl = request.getRequestURI();
        HttpSession session = request.getSession();

        System.out.println("this is MyFilter,url :" + FilterUrl);
        /*除了已经登入 并且是有相应的权限*/
         if (FilterUrl.indexOf("/department/")!=-1 ) {

                 if (StringUtils.isEmpty(session.getAttribute("adminName"))) {
                  response.sendRedirect(request.getContextPath() + "/login.html?&error=1");
                  }
               /*否则进入index.html*/
            }
        if (isCorrect(FilterUrl)) {
            /*处理请求index的*/
             logger.info(session.getAttribute("adminName"));
            if (FilterUrl.equals("/index.html")) {
                 if (StringUtils.isEmpty(session.getAttribute("adminName"))) {
                  response.sendRedirect(request.getContextPath() + "/login.html?&error=1");
                  }
               /*否则进入index.html*/
            }
            /*再次处理请求department*/

                filterChain.doFilter(srequest, sresponse);
        } else {
            filterChain.doFilter(srequest, sresponse);
        }
        return;
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }

    boolean isCorrect(String getUrl) {
        for (String s : url) {
            if (s.equals(getUrl))
                return true;
        }
        return false;
    }

}