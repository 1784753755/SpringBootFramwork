package com.model;
/*产品类别*/
public class ProductCategory {

private int  categoryId;
/*名字*/
private String title;
/*商品上级id*/
private int upper;
/*审核状态*/
private  int status;
/*显示状态*/
private int list;
private  String img;
private String createTime;
/*所属网站id*/
private  int uid;
private  int type;

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", upper=" + upper +
                ", status=" + status +
                ", list=" + list +
                ", img='" + img + '\'' +
                ", createTime='" + createTime + '\'' +
                ", uid=" + uid +
                ", type=" + type +
                '}';
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUpper() {
        return upper;
    }

    public void setUpper(int upper) {
        this.upper = upper;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getList() {
        return list;
    }

    public void setList(int list) {
        this.list = list;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
