package com.service;

import com.model.GotSubOrder;
import com.model.Order;
import com.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> getAllOrders();

    /*获取所有的数目*/
    Integer countOrder();
    /*获取特定Order*/
    /*导航查询查询*/
    Order getOrderById(Integer getOrderId);

    List<Order> getAuthorByWebName(String trim);

    /*List<Order> getAuthorByProductName(String trim);*/

    List<Order> getAuthorByUserName(String trim);

    List<Order> getAuthorByUserTel(String trim);

    List<Order> getAuthorByIP(String trim);

    List<Order> getAuthorByOrderNum(String trim);
    void  makeOrder(List<GotSubOrder> list, User user);
}
