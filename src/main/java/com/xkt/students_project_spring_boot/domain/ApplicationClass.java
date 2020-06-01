package com.xkt.students_project_spring_boot.domain;

import java.io.Serializable;
import java.util.Date;

public class ApplicationClass implements Serializable {
//    换班表id
    private Integer caId;
//新版id
    private Integer nowClassId;
//原版id
    private Integer wantClassId;
    //    申请时间
    private Date applicantDate;
    //理由
    private String reason;
    //申请人id
    private Integer applicatId;
    //换版学生Id
    private Integer stuId;
    //审核日期
    private Date reviewDate;
    //审核理由
    private String reviewReason;
    //审核人Id
    private Integer reviewId;
    //状态
    private String state;
//    学生姓名
private String stuName;

    @Override
    public String toString() {
        return "ApplicationClass{" +
                "caId=" + caId +
                ", nowClassId='" + nowClassId + '\'' +
                ", wantClassId=" + wantClassId +
                ", applicantDate=" + applicantDate +
                ", reason='" + reason + '\'' +
                ", applicatId=" + applicatId +
                ", stuId=" + stuId +
                ", reviewDate=" + reviewDate +
                ", reviewReason='" + reviewReason + '\'' +
                ", reviewId=" + reviewId +
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

    public Integer getCaId() {
        return caId;
    }

    public void setCaId(Integer caId) {
        this.caId = caId;
    }

    public Integer getNowClassId() {
        return nowClassId;
    }

    public void setNowClassId(Integer nowClassId) {
        this.nowClassId = nowClassId;
    }

    public Integer getWantClassId() {
        return wantClassId;
    }

    public void setWantClassId(Integer wantClassId) {
        this.wantClassId = wantClassId;
    }

    public Date getApplicantDate() {
        return applicantDate;
    }

    public void setApplicantDate(Date applicantDate) {
        this.applicantDate = applicantDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
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

    public String getReviewReason() {
        return reviewReason;
    }

    public void setReviewReason(String reviewReason) {
        this.reviewReason = reviewReason;
    }

}
