package com.displayController;


import com.common.GetIp;
import com.common.Log;
import com.common.RequestSource;
import com.model.GotSubOrder;
import com.model.User;
import com.service.OrderService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class OrderMakeController {
    //    生成订单
    @Autowired
    private OrderService orderService;


    @RequestMapping("/sumOrder.do")
    public String makeOrder(HttpServletRequest request) {
        String getUserName = request.getParameter("uname");
        String getTel = request.getParameter("utel");
        String getEmail = request.getParameter("uemail");
        String getPostCode = request.getParameter("upostcode");
        String getAddress = request.getParameter("uaddress");
//    用户的备注
        String getRemarks = request.getParameter("uremarks");
        String order = request.getParameter("order");
//
        User user = new User();
        user.setAddress(getAddress);
        user.setEmail(getEmail);
        user.setPostCode(Integer.valueOf(getPostCode));
        user.setTel(Double.valueOf(getTel));
        user.setRemarks(getRemarks);
        user.setName(getUserName);
//        设置主机ip
        user.setHostIp(GetIp.showCurrentIp(request));
//        设置请求url
        user.setDomainHost(GetIp.showCurrentUrl(request));
//        设置请（手机端请求1：pc端0）
       if(RequestSource.isMobile(request))
        user.setSource(1);
       else
           user.setSource(0);
        JSONArray json = JSONArray.fromObject(order);//userStr是json字符串
        Log.showLog(json.get(0).toString());
        List<GotSubOrder> GotSubOrders = (List<GotSubOrder>) JSONArray.toCollection(json, GotSubOrder.class);
          /* for(GotSubOrder s:GotSubOrders){
               Log.showLog(s.toString());
           }*/
        orderService.makeOrder(GotSubOrders, user);
        return "success";
    }
}
