package com.model.domain;

import java.util.List;

public class StandProduct {
    /*产品id*/
    private  int id;
    private String name;
    /*排序*/
    private int Order;
    private String category;
    /*库存量*/
    private int StoreNum;
    /*销售量*/
    private int count;
    private float price;
    /*审核状态*/
    private String status;
    /*显示状态*/
    private String type;
    /*是否推荐*/
    private String isTop;
/*商品主图*/


    @Override
    public String toString() {
        return "StandProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Order=" + Order +
                ", category='" + category + '\'' +
                ", StoreNum=" + StoreNum +
                ", count=" + count +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", isTop='" + isTop + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return Order;
    }

    public void setOrder(int order) {
        Order = order;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStoreNum() {
        return StoreNum;
    }

    public void setStoreNum(int storeNum) {
        StoreNum = storeNum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }
}
