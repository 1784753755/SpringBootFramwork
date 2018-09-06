package com.dao;

import com.common.AbstractPageForm;
import com.model.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderDao {
    List<Order> getAllOrder();

    List<Order> getOrderBySelect(AbstractPageForm abstractPageForm);
    void saveOrder(Order order);
    void  updateOrder(Order order);
    Order getOrderById(Integer OrderId);
    List<Order> getOrderTime(@Param("beginTime") String beginTime,@Param("endTime") String endTime,AbstractPageForm abstractPageForm);

    Integer getCountOrder();

    List<Order> getOrderByWebName(@Param("webName") String trim);



    List<Order> getOrderByUserName(@Param("UserName")String trim);

    List<Order> getOrderByUserTel(@Param("UserTel")String trim);

    List<Order> getOrderByIP(@Param("IP")String trim);

    List<Order> getOrderByOrderNum(@Param("OrderNum")String trim);
}
