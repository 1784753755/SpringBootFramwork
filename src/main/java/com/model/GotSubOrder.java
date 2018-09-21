package com.model;

public class GotSubOrder {

//    {"g_id":"340","g_color":"rc3","g_package":"r1","g_name":"淘气","g_price":13332,"g_img":"/static/images/upload/addProduct/c3d74492-633e-4ff5-b262-a1c2ba59a838.jpg","g_color_name":"14","g_package_name":"套餐5","num":"2"}

    private int g_id;
    private int g_color;
    private int g_package;
    private String g_name;
    private float g_price;
    private String g_img;
    private String g_color_name;
    private String g_package_name;
    private int num;

    @Override
    public String toString() {
        return "GotSubOrder{" +
                "g_id='" + g_id + '\'' +
                ", g_color='" + g_color + '\'' +
                ", g_package='" + g_package + '\'' +
                ", g_name='" + g_name + '\'' +
                ", g_price=" + g_price +
                ", g_img='" + g_img + '\'' +
                ", g_color_name='" + g_color_name + '\'' +
                ", g_package_name='" + g_package_name + '\'' +
                ", num=" + num +
                '}';
    }

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public int getG_color() {
        return g_color;
    }

    public void setG_color(int g_color) {
        this.g_color = g_color;
    }

    public int getG_package() {
        return g_package;
    }

    public void setG_package(int g_package) {
        this.g_package = g_package;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public float getg_price() {
        return g_price;
    }

    public void setg_price(float g_price) {
        this.g_price = g_price;
    }

    public String getG_img() {
        return g_img;
    }

    public void setG_img(String g_img) {
        this.g_img = g_img;
    }

    public String getG_color_name() {
        return g_color_name;
    }

    public void setG_color_name(String g_color_name) {
        this.g_color_name = g_color_name;
    }

    public String getG_package_name() {
        return g_package_name;
    }

    public void setG_package_name(String g_package_name) {
        this.g_package_name = g_package_name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
