package com.model;

import java.util.List;

public class DetailOrder {
    /*详细的输出订单的详情页*/
    /*域名	域名地址	域名拥有者	客户地址	邮编	邮箱	备注	运单号	出货日期*/
    /*商品名称	商品颜色	商品尺码	商品套餐	商品价格	商品数量*/
    private String domainHostUrl;
    private String ipAddress;
    private String User;
    private String customerAddress;
    /*邮编*/
    private Integer user_postal;
    private String user_email;
    /*备注*/
    private String  user_connect;
    /*运单号*/
    private  String waybillNumber;
    private  String shipDate;
    /*商品的属性*/
    private List<OrderDetail> getOrderDetail;

    @Override
    public String toString() {
        return "DetailOrder{" +
                "domainHostUrl='" + domainHostUrl + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", User='" + User + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", user_postal='" + user_postal + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_connect='" + user_connect + '\'' +
                ", waybillNumber='" + waybillNumber + '\'' +
                ", shipDate='" + shipDate + '\'' +
                ", getOrderDetail=" + getOrderDetail +
                '}';
    }

    public String getDomainHostUrl() {
        return domainHostUrl;
    }

    public void setDomainHostUrl(String domainHostUrl) {
        this.domainHostUrl = domainHostUrl;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Integer getUser_postal() {
        return user_postal;
    }

    public void setUser_postal(Integer user_postal) {
        this.user_postal = user_postal;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_connect() {
        return user_connect;
    }

    public void setUser_connect(String user_connect) {
        this.user_connect = user_connect;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public List<OrderDetail> getGetOrderDetail() {
        return getOrderDetail;
    }

    public void setGetOrderDetail(List<OrderDetail> getOrderDetail) {
        this.getOrderDetail = getOrderDetail;
    }
}
