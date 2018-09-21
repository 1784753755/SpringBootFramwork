package com.dao;

import com.model.OrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailDao {
      List<OrderDetail> getDetailByOrderNum(String orderNum);

      void insertOrderDetail(OrderDetail orderDetail);
}
