package com.model;

/**
 * 订单明细
 */
public class OrderDetail {

    private String orderId;
    private Integer colorId;
    private Integer sizeId;
    private float price;
    private String  color;
    private String  size;
    private Integer goodsId;
    private String img;
    private Integer num;
    private String packages;
    private Integer packageId;
    private String title;
    private String moneyType;
    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderId='" + orderId + '\'' +
                ", colorId=" + colorId +
                ", sizeId=" + sizeId +
                ", price=" + price +
                ", color=" + color +
                ", size=" + size +
                ", goodsId=" + goodsId +
                ", img='" + img + '\'' +
                ", num=" + num +
                ", packages='" + packages + '\'' +
                ", packageId=" + packageId +
                ", title='" + title + '\'' +
                ", moneyType='" + moneyType + '\'' +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String  getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }
}
