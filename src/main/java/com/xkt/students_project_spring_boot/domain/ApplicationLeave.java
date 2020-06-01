package com.xkt.students_project_spring_boot.domain;

import java.io.Serializable;
import java.util.Date;

public class ApplicationLeave implements Serializable {
    //    换宿申请id
    private Integer alId;
    //    学生姓名
    private  String stuName;

    //申请日期
    private Date applicationDate;
    //申请人id
    private Integer applicationId;
    //请假学生Id
    private Integer stuId;
    //请假理由
    private String reason;
//    请假天数
    private Integer days;
//    销假日期
    private Date ruinDate;

    //一审核日期
    private Date oneReviewDate;
    //一审核理由
    private String oneReviewReason;
    //一审核人Id
    private Integer oneReviewId;
    //状态
    private String state;
    //二审核日期
    private Date twoReviewDate;
    //二审核理由
    private String twoReviewReason;
    //二审核人Id
    private Integer twoReviewId;
    //三审核日期
    private Date threeReviewDate;
    //三审核理由
    private String threeReviewReason;
    //三审核人Id
    private Integer threeReviewId;

    public Integer getAlId() {
        return alId;
    }

    public void setAlId(Integer alId) {
        this.alId = alId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Date getRuinDate() {
        return ruinDate;
    }

    public void setRuinDate(Date ruinDate) {
        this.ruinDate = ruinDate;
    }

    public Date getOneReviewDate() {
        return oneReviewDate;
    }

    public void setOneReviewDate(Date oneReviewDate) {
        this.oneReviewDate = oneReviewDate;
    }

    public String getOneReviewReason() {
        return oneReviewReason;
    }

    public void setOneReviewReason(String oneReviewReason) {
        this.oneReviewReason = oneReviewReason;
    }

    public Integer getOneReviewId() {
        return oneReviewId;
    }

    public void setOneReviewId(Integer oneReviewId) {
        this.oneReviewId = oneReviewId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getTwoReviewDate() {
        return twoReviewDate;
    }

    public void setTwoReviewDate(Date twoReviewDate) {
        this.twoReviewDate = twoReviewDate;
    }

    public String getTwoReviewReason() {
        return twoReviewReason;
    }

    public void setTwoReviewReason(String twoReviewReason) {
        this.twoReviewReason = twoReviewReason;
    }

    public Integer getTwoReviewId() {
        return twoReviewId;
    }

    public void setTwoReviewId(Integer twoReviewId) {
        this.twoReviewId = twoReviewId;
    }

    public Date getThreeReviewDate() {
        return threeReviewDate;
    }

    public void setThreeReviewDate(Date threeReviewDate) {
        this.threeReviewDate = threeReviewDate;
    }

    public String getThreeReviewReason() {
        return threeReviewReason;
    }

    public void setThreeReviewReason(String threeReviewReason) {
        this.threeReviewReason = threeReviewReason;
    }

    public Integer getThreeReviewId() {
        return threeReviewId;
    }

    public void setThreeReviewId(Integer threeReviewId) {
        this.threeReviewId = threeReviewId;
    }

    @Override
    public String toString() {
        return "ApplicationLeave{" +
                "alId=" + alId +
                ", stuName='" + stuName + '\'' +
                ", applicationDate=" + applicationDate +
                ", applicationId=" + applicationId +
                ", stuId=" + stuId +
                ", reason='" + reason + '\'' +
                ", days=" + days +
                ", ruinDate=" + ruinDate +
                ", oneReviewDate=" + oneReviewDate +
                ", oneReviewReason='" + oneReviewReason + '\'' +
                ", oneReviewId=" + oneReviewId +
                ", state='" + state + '\'' +
                ", twoReviewDate=" + twoReviewDate +
                ", twoReviewReason='" + twoReviewReason + '\'' +
                ", twoReviewId=" + twoReviewId +
                ", threeReviewDate=" + threeReviewDate +
                ", threeReviewReason='" + threeReviewReason + '\'' +
                ", threeReviewId=" + threeReviewId +
                '}';
    }
}
