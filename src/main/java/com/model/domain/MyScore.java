package com.model.domain;

public class MyScore {
    private String courseName;
    private int score;
    private String teacherName;
    private String leaveMessage;

    @Override
    public String toString() {
        return "MyScore{" +
                "courseName='" + this.courseName + '\'' +
                ", score=" + this.score +
                ", teacherName='" + this.teacherName + '\'' +
                ", leaveMessage='" + this.leaveMessage + '\'' +
                '}';
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getLeaveMessage() {
        return this.leaveMessage;
    }

    public void setLeaveMessage(String leaveMessage) {
        this.leaveMessage = leaveMessage;
    }
}
