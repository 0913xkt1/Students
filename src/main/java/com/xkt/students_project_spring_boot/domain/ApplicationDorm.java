package com.xkt.students_project_spring_boot.domain;

import java.io.Serializable;
import java.util.Date;

public class ApplicationDorm implements Serializable {
//    换宿申请id
    private Integer laId;
//    学生姓名
    private  String stuName;
//    新宿舍id
    private Integer nowDormId;
//    原宿舍id
    private Integer wantDormId;
    //申请日期
    private Date applyForDate;
    //申请人id
    private Integer applicatId;
    //换宿学生Id
    private Integer stuId;
    //换宿理由
    private String reason;
    //审核日期
    private Date reviewDate;
    //审核理由
    private String reviewReason;
    //审核人Id
    private Integer reviewId;
    //状态
    private String state;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }


    public Integer getLaId() {
        return laId;
    }

    public void setLaId(Integer laId) {
        this.laId = laId;
    }



    public Integer getNowDormId() {
        return nowDormId;
    }

    public void setNowDormId(Integer nowDormId) {
        this.nowDormId = nowDormId;
    }

    public Integer getWantDormId() {
        return wantDormId;
    }

    public void setWantDormId(Integer wantDormId) {
        this.wantDormId = wantDormId;
    }

    public Date getApplyForDate() {
        return applyForDate;
    }

    public void setApplyForDate(Date applyForDate) {
        this.applyForDate = applyForDate;
    }

    public Integer getApplicatId() {
        return applicatId;
    }

    public void setApplicatId(Integer applicatId) {
        this.applicatId = applicatId;
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

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewReason() {
        return reviewReason;
    }

    public void setReviewReason(String reviewReason) {
        this.reviewReason = reviewReason;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ApplicationDorm{" +
                "laId=" + laId +
                ", stuName=" + stuName +
                ", nowDormId=" + nowDormId +
                ", wantDormId=" + wantDormId +
                ", applyForDate=" + applyForDate +
                ", applicatId=" + applicatId +
                ", stuId=" + stuId +
                ", reason='" + reason + '\'' +
                ", reviewDate=" + reviewDate +
                ", reviewReason='" + reviewReason + '\'' +
                ", reviewId=" + reviewId +
                ", state='" + state + '\'' +
                '}';
    }
}
