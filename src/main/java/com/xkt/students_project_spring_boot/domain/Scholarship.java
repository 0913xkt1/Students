package com.xkt.students_project_spring_boot.domain;

import java.io.Serializable;
import java.util.Date;

public class Scholarship implements Serializable {
//    奖学金申请ID
    private Integer scholarshipId;
//    学生Id
    private Integer stuId;
//    学生姓名
    private String stuName;
//    成绩级别
    private String scopeType;
//    申请时间
    private Date applyForDate;
//    理由
    private String reason;
//    状态
    private String state;
//    审核理由
    private String reviewReason;
//    审核老师id
    private Integer teaId;
//    审核时间
    private Date reviewDate;

    public Integer getScholarshipId() {
        return scholarshipId;
    }

    public void setScholarshipId(Integer scholarshipId) {
        this.scholarshipId = scholarshipId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getScopeType() {
        return scopeType;
    }

    public void setScopeType(String scopeType) {
        this.scopeType = scopeType;
    }

    public Date getApplyForDate() {
        return applyForDate;
    }

    public void setApplyForDate(Date applyForDate) {
        this.applyForDate = applyForDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "Scholarship{" +
                "scholarshipId=" + scholarshipId +
                ", stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", scopeType='" + scopeType + '\'' +
                ", applyForDate=" + applyForDate +
                ", reason='" + reason + '\'' +
                ", state='" + state + '\'' +
                ", reviewReason='" + reviewReason + '\'' +
                ", teaId=" + teaId +
                ", reviewDate=" + reviewDate +
                '}';
    }
}
