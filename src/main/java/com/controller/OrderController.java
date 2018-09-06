package com.controller;

import com.model.AuthorGroup;
import com.model.DetailOrder;
import com.model.Order;
import com.model.OrderDetail;
import com.service.AuthorService;
import com.service.OrderDetailService;
import com.service.OrderService;
import com.service.SelectPageService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @OrderController 订单连接匹配
 * @Author cai sheng tang
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private SelectPageService selectPageService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping("/getAllOrders.do")
    public List<Order> getAllOrders(HttpServletRequest request) {
        String getPageSize = request.getParameter("pageSize");
        String getPageIndex = request.getParameter("pageIndex");
        Integer pageSize = Integer.valueOf(getPageSize);
        Integer pageIndex = Integer.valueOf(getPageIndex);
        //获取所有的订单
        List<Order> list = selectPageService.selectOrder(pageSize, pageIndex).getList();
        return list;
    }

    @RequestMapping("/getCountOrder.do")
    public String getCountOrder() {
        Integer getCountOrders = orderService.countOrder();
        return getCountOrders + "";
    }

    /*通过获取id获取详细的信息*/
    @RequestMapping("/getOrderDetail.do")
    public DetailOrder getOrderByDetail(HttpServletRequest request) {
        String OrderId = request.getParameter("OrderId");
        Integer getOrderId = Integer.valueOf(OrderId);
        Order order = orderService.getOrderById(getOrderId);
        /*根据order 域名获取站点持有者*/
        String getDomainUrl = order.getDomainHostUrl();
        AuthorGroup authorGroup;
        /*订单号*/
        String orderNum = order.getOrderNum();
        authorGroup = authorService.getAuthorByHostUrl(getDomainUrl);
        if(authorGroup==null)
            return null;
        /*获取商品明细*/
        List<OrderDetail> orderDetails = orderDetailService.getOrderDetail(orderNum);
        /*标准输出*/
        DetailOrder detailOrder = new DetailOrder();

        detailOrder.setDomainHostUrl(order.getDomainHostUrl());
        detailOrder.setUser(authorGroup.getWebNames());
        /*设置地址*/
         detailOrder.setCustomerAddress(order.getUserAddress());
         /*设置邮编*/
        detailOrder.setUser_postal(order.getUserPostal());
        /*设置备注*/
        detailOrder.setUser_connect(order.getUserConnect());
        detailOrder.setGetOrderDetail(orderDetails);

        detailOrder.setShipDate(0 + "");


        /*根据order 域名获取站点持有者*/
        /*"id","uid","web_url","status","addtime","list","web_names","type","grouping","Movement"*/
        return detailOrder;
    }

    @RequestMapping("/getOrderByMethod.do")
    public List<Order> searchByMethod(HttpServletRequest request){
    String getWay=    request.getParameter("way");
    String getContent=request.getParameter("content");
     List<Order> getList=null;
         /*<option value="1">网站名称</option>
                <option value="2">商品名称</option>
                <option value="3">客户姓名</option>
                <option value="4">客户手机</option>
                <option value="5">IP查询</option>
                <option value="6">订单号查询</option>*/
    switch (getWay.trim()){
            case "1":{
             getList= orderService.getAuthorByWebName(getContent.trim());
                break;
            }
            case "2":{
             /*   getList= orderService.getAuthorByProductName(getContent.trim());*/
             break;
            }
            case "3":{
                getList= orderService.getAuthorByUserName(getContent.trim());
                  break;
            }
            case "4":{
                getList= orderService.getAuthorByUserTel(getContent.trim());
                  break;
            }
             case "5":{
                getList= orderService.getAuthorByIP(getContent.trim());
                  break;
            }
             case "6":{
                getList= orderService.getAuthorByOrderNum(getContent.trim());
                  break;
            }
        }

        return  getList;
    }
}
