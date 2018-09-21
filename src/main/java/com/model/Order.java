package com.model;

public class Order {
    private Integer orderId;
    private String  orderNum;
    private Integer phoneNumb;
    private Integer ipNumb;
    private String  Ip;
    private float   goodsTatalPrice;
    private String  userName;
    private String  userPhone;
    /*邮费*/
    private Integer userPostal;
    /*备注*/
    private String  userConnect;
    private String  userEmail;
    private String  userAddress;
    private String  createTime;
    private Integer uId;
    private String  domainHostUrl;
    private String  moneyType;
    private Integer source;
    private int  state1;
    private Integer state2;
    private int  state3;
    private String  type1;
    private String  timeOfReceipt;
    private String  DeliveryMeth;
    private String  prizeCode;
    private String  goodsPackage;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderNum='" + orderNum + '\'' +
                ", phoneNumb=" + phoneNumb +
                ", ipNumb=" + ipNumb +
                ", Ip='" + Ip + '\'' +
                ", goodsTatalPrice=" + goodsTatalPrice +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPostal=" + userPostal +
                ", userConnect='" + userConnect + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", createTime='" + createTime + '\'' +
                ", uId=" + uId +
                ", domainHostUrl='" + domainHostUrl + '\'' +
                ", moneyType='" + moneyType + '\'' +
                ", source=" + source +
                ", state1='" + state1 + '\'' +
                ", state2=" + state2 +
                ", state3='" + state3 + '\'' +
                ", type1='" + type1 + '\'' +
                ", timeOfReceipt='" + timeOfReceipt + '\'' +
                ", DeliveryMeth='" + DeliveryMeth + '\'' +
                ", prizeCode='" + prizeCode + '\'' +
                ", goodsPackage='" + goodsPackage + '\'' +
                '}';
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(Integer phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    public Integer getIpNumb() {
        return ipNumb;
    }

    public void setIpNumb(Integer ipNumb) {
        this.ipNumb = ipNumb;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public float getGoodsTatalPrice() {
        return goodsTatalPrice;
    }

    public void setGoodsTatalPrice(float goodsTatalPrice) {
        this.goodsTatalPrice = goodsTatalPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getUserPostal() {
        return userPostal;
    }

    public void setUserPostal(Integer userPostal) {
        this.userPostal = userPostal;
    }

    public String getUserConnect() {
        return userConnect;
    }

    public void setUserConnect(String userConnect) {
        this.userConnect = userConnect;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getDomainHostUrl() {
        return domainHostUrl;
    }

    public void setDomainHostUrl(String domainHostUrl) {
        this.domainHostUrl = domainHostUrl;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public int getState1() {
        return state1;
    }

    public void setState1(int state1) {
        this.state1 = state1;
    }

    public Integer getState2() {
        return state2;
    }

    public void setState2(Integer state2) {
        this.state2 = state2;
    }

    public int getState3() {
        return state3;
    }

    public void setState3(int state3) {
        this.state3 = state3;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String gettimeOfReceipt() {
        return timeOfReceipt;
    }

    public void settimeOfReceipt(String timeOfReceipt) {
        this.timeOfReceipt = timeOfReceipt;
    }

    public String getDeliveryMeth() {
        return DeliveryMeth;
    }

    public void setDeliveryMeth(String deliveryMeth) {
        DeliveryMeth = deliveryMeth;
    }

    public String getPrizeCode() {
        return prizeCode;
    }

    public void setPrizeCode(String prizeCode) {
        this.prizeCode = prizeCode;
    }

    public String getGoodsPackage() {
        return goodsPackage;
    }

    public void setGoodsPackage(String goodsPackage) {
        this.goodsPackage = goodsPackage;
    }


}
