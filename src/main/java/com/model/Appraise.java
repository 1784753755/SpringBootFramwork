package com.model;

public class Appraise {
    private  String commentator;
    private Integer order ;
    private  String addTime;
    private  Integer status;
    private String imgList;
    private  String  describle;
    private  String avatarImg ;
    private Integer upper;
    private Integer appraiseId;

    @Override
    public String toString() {
        return "Appraise{" +
                "commentator='" + commentator + '\'' +
                ", order=" + order +
                ", addTime='" + addTime + '\'' +
                ", status=" + status +
                ", imgList='" + imgList + '\'' +
                ", describle='" + describle + '\'' +
                ", avatarImg='" + avatarImg + '\'' +
                ", upper=" + upper +
                ", appraiseId=" + appraiseId +
                '}';
    }

    public String getCommentator() {
        return commentator;
    }

    public void setCommentator(String commentator) {
        this.commentator = commentator;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImgList() {
        return imgList;
    }

    public void setImgList(String imgList) {
        this.imgList = imgList;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle;
    }

    public String getAvatarImg() {
        return avatarImg;
    }

    public void setAvatarImg(String avatarImg) {
        this.avatarImg = avatarImg;
    }

    public Integer getUpper() {
        return upper;
    }

    public void setUpper(Integer upper) {
        this.upper = upper;
    }

    public Integer getAppraiseId() {
        return appraiseId;
    }

    public void setAppraiseId(Integer appraiseId) {
        this.appraiseId = appraiseId;
    }
}
