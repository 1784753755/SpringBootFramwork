package com.model;

public class User {
    private  String name;
    private  double tel;
    private  String email;
    private  String address;
    private  int postCode;
    private  String remarks;
    private  String hostIp;
    private String domainHost;
//    请求的工具
    private  int source;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", tel=" + tel +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", postCode=" + postCode +
                ", remarks='" + remarks + '\'' +
                ", hostIp='" + hostIp + '\'' +
                ", domainHost='" + domainHost + '\'' +
                ", source=" + source +
                '}';
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getDomainHost() {
        return domainHost;
    }

    public void setDomainHost(String domainHost) {
        this.domainHost = domainHost;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTel() {
        return tel;
    }

    public void setTel(double tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
