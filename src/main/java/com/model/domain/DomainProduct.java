package com.model.domain;

import com.model.Color;
import com.model.Package;

import java.util.List;

/*产品展示*/
public class DomainProduct {
    /**/
    private String imgMain;
    private List<String> imgList;
    private  String name;
    private Integer num;
    private  float oldPrice;
    private  float nowPrice;
    private List<Color> color;
    private List<Package> aPackage;
    private Integer id;

    private  String  Detail;

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgMain() {
        return imgMain;
    }

    public void setImgMain(String imgMain) {
        this.imgMain = imgMain;
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public float getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(float oldPrice) {
        this.oldPrice = oldPrice;
    }

    public float getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(float nowPrice) {
        this.nowPrice = nowPrice;
    }

    @Override
    public String toString() {
        return "DomainProduct{" +
                "imgMain='" + imgMain + '\'' +
                ", imgList=" + imgList +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", oldPrice=" + oldPrice +
                ", nowPrice=" + nowPrice +
                ", color=" + color +
                ", aPackage=" + aPackage +
                ", id=" + id +
                ", Detail='" + Detail + '\'' +
                '}';
    }

    public List<Color> getColor() {
        return color;
    }

    public void setColor(List<Color> color) {
        this.color = color;
    }

    public List<Package> getaPackage() {
        return aPackage;
    }

    public void setaPackage(List<Package> aPackage) {
        this.aPackage = aPackage;
    }
}

