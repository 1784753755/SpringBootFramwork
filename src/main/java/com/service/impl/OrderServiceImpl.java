package com.service.impl;

import com.dao.OrderDao;
import com.model.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrder();
    }

    @Override
    public Integer countOrder() {
        return orderDao.getCountOrder();
    }

    @Override
    public Order getOrderById(Integer getOrderId) {
        return orderDao.getOrderById(getOrderId);
    }

    /*导航栏查询*/
    @Override
    public List<Order> getAuthorByWebName(String trim) {
        return orderDao.getOrderByWebName(trim);
    }

    @Override
    public List<Order> getAuthorByUserName(String trim) {
        return orderDao.getOrderByUserName(trim);
    }

    @Override
    public List<Order> getAuthorByUserTel(String trim) {
        return orderDao.getOrderByUserTel(trim);
    }

    @Override
    public List<Order> getAuthorByIP(String trim) {
        return orderDao.getOrderByIP(trim);
    }

    @Override
    public List<Order> getAuthorByOrderNum(String trim) {
        return orderDao.getOrderByOrderNum(trim);
    }

}
