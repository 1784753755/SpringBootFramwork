package com.service;

import com.model.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailService {

    List<OrderDetail> getOrderDetail(String orderNum);

    void addOrderDetail(OrderDetail orderDetail);
}
