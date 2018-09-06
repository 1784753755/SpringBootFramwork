package com.model;

public class Color {
    private  Integer colorId;
    private  String title;
    private  Integer goodsId;
    private  Integer status;
    private  float goodsPrice;
    private Integer type;

    @Override
    public String toString() {
        return "Color{" +
                "colorId=" + colorId +
                ", title='" + title + '\'' +
                ", goodsId=" + goodsId +
                ", status=" + status +
                ", goodsPrice=" + goodsPrice +
                ", type=" + type +
                '}';
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
