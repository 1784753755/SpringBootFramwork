package com.service.impl;

import com.dao.OrderDetailDao;
import com.model.OrderDetail;
import com.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public List<OrderDetail> getOrderDetail(String orderNum) {
        return  orderDetailDao.getDetailByOrderNum(orderNum);
    }

    @Override
    public void addOrderDetail(OrderDetail orderDetail) {

        orderDetailDao.insertOrderDetail(orderDetail);
    }
}
