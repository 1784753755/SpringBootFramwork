package com.model;

public class AuthorGroup {
    /*表id*/
   private Integer authorId;
   /*userid*/
    private Integer uid;
    /*域名*/
    private String webUrl;
    /*审核状态*/
    private Integer status;
    /*增加时间*/
    private String addTime;
    /*排序*/
    private  Integer list;
    private  String webNames;
    /*地区*/
    private  String type;
    /*部门*/
    private  String grouping;
    /*运营状态*/
    private String movement;
    private Admin admin;

    @Override
    public String toString() {
        return "AuthorGroup{" +
                "authorId=" + authorId +
                ", uid=" + uid +
                ", webUrl='" + webUrl + '\'' +
                ", status=" + status +
                ", addTime='" + addTime + '\'' +
                ", list=" + list +
                ", webNames='" + webNames + '\'' +
                ", type='" + type + '\'' +
                ", grouping='" + grouping + '\'' +
                ", movement='" + movement + '\'' +
                ", admin=" + admin +
                '}';
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Integer getList() {
        return list;
    }

    public void setList(Integer list) {
        this.list = list;
    }

    public String getWebNames() {
        return webNames;
    }

    public void setWebNames(String webNames) {
        this.webNames = webNames;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }
}
