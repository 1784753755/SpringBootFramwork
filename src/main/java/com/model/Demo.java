package com.model;

public class Demo {
    private int testId;
    private String name;
    private String pwd;

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + this.testId +
                ", name='" + this.name + '\'' +
                ", pwd='" + this.pwd + '\'' +
                '}';
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getTestId() {
        return this.testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
