package com.model;


public class Admin {
    /*员工序列*/
    private int adminId;
    private  int power=0;

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", power=" + power +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", changePwd='" + changePwd + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", hits=" + hits +
                ", ip='" + ip + '\'' +
                ", lastIp='" + lastIp + '\'' +
                ", time='" + time + '\'' +
                ", lastTime='" + lastTime + '\'' +
                ", addTime='" + addTime + '\'' +
                ", status=" + status +
                '}';
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    private String name;
    private String pwd;
    /*管理员更改密码时间*/
    private String changePwd;
    private String email;
    /*头像*/
    private String avatar;
    /*登录次数*/
    private int hits;
    private String ip;
    private String lastIp;
    /*登录时间*/
    private String time;
    /*上次登录时间*/
    private String lastTime;
    /*添加时间*/
    private String addTime;
    /*审核状态 正数*/
    private int status;

    public String getLastIp() {
        return this.lastIp;
    }

    public int getAdminId() {
        return this.adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public String getChangePwd() {
        return this.changePwd;
    }

    public void setChangePwd(String changePwd) {
        this.changePwd = changePwd;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLastTime() {
        return this.lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getAddTime() {
        return this.addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getHits() {
        return this.hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
