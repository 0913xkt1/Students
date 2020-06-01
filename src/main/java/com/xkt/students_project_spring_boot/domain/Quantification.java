package com.xkt.students_project_spring_boot.domain;

import java.io.Serializable;
import java.util.Date;

public class Quantification implements Serializable {
//    量化id
    private Integer quanId;
//    输入时间
    private Date quanDate;
//    学生ID
    private Integer stuId;
//    分数
    private Double score;
//    理由
    private String reason;
//    输入教师Id
    private Integer teaId;
//状态
    private String state;
//    学生姓名
private String stuName;

    @Override
    public String toString() {
        return "Quantification{" +
                "quanId=" + quanId +
                ", quanDate=" + quanDate +
                ", stuId=" + stuId +
                ", score=" + score +
                ", reason='" + reason + '\'' +
                ", teaId=" + teaId +
                ", state='" + state + '\'' +
                ", stuName='" + stuName + '\'' +
                '}';
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getQuanId() {
        return quanId;
    }

    public void setQuanId(Integer quanId) {
        this.quanId = quanId;
    }

    public Date getQuanDate() {
        return quanDate;
    }

    public void setQuanDate(Date quanDate) {
        this.quanDate = quanDate;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

}
