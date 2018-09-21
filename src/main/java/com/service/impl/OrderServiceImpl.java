package com.service.impl;

import com.common.Log;
import com.common.RandomOrderNum;
import com.common.Time;
import com.dao.OrderDao;
import com.model.GotSubOrder;
import com.model.Order;
import com.model.OrderDetail;
import com.model.User;
import com.service.OrderDetailService;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderDetailService orderDetailService;

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

    @Override
    public void makeOrder(List<GotSubOrder> list, User user) {
        //生成一个订单 同时完成订单下明细
        float price = 0;
        for (int i = 0; i < list.size(); i++) {
            price += list.get(i).getg_price();
        }
        Order order = new Order();
        //生成唯一不重复的orderNum
        String orderNUM=RandomOrderNum.makeOrderNum();
        order.setOrderNum(orderNUM);
        order.setCreateTime(Time.getCurrentTime());
        order.setuId(1);
        order.setDeliveryMeth("");
        order.setGoodsTatalPrice(price);

        //同一ip订单数
        order.setIpNumb(list.size());
        order.setIp(user.getHostIp());
        order.setDomainHostUrl(user.getDomainHost());

        order.setMoneyType("NT$");
        //获取当前是请求是pc 还是phone
        order.setSource(user.getSource());
        order.setState1(1);
        //设置用户联系手机号码
        order.setUserPhone(user.getTel() + "");
        order.setUserPostal(user.getPostCode());
        order.setUserEmail(user.getEmail());
        order.setUserAddress(user.getAddress());
        order.setUserName(user.getName());
        order.setPrizeCode("未参与");

        //备注
        order.setUserConnect(user.getRemarks());

        orderDao.saveOrder(order);
        //生成订单同时产生订单明细
      if( setOrderDetail(list,orderNUM)) {
          Log.showLog("success");
      }

    }



    public boolean setOrderDetail(List<GotSubOrder> list, String orderNum) {
        boolean success=true;
        OrderDetail orderDetail;
        for (int i = 0; i < list.size(); i++) {
            orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderNum);
            orderDetail.setColorId(list.get(i).getG_color());
            orderDetail.setColor(list.get(i).getG_color_name());
            orderDetail.setGoodsId(list.get(i).getG_id());
            orderDetail.setImg(list.get(i).getG_img());
//            设置币种需要结合前台提供的币种类型给予选择在设定 默认设定为NT$
            orderDetail.setMoneyType("NT$");
            orderDetail.setPackageId(list.get(i).getG_package());
            orderDetail.setPackages(list.get(i).getG_package_name());
            orderDetail.setNum(list.get(i).getNum());
            orderDetail.setPrice(list.get(i).getg_price());
            orderDetail.setSizeId(-1);
            orderDetail.setSize("无");
            orderDetail.setTitle(list.get(i).getG_name());
            try {
                orderDetailService.addOrderDetail(orderDetail);
            } catch (Exception e) {
                success=false;
                e.printStackTrace();
                continue;
            }
        }
        return success;
    }

}
