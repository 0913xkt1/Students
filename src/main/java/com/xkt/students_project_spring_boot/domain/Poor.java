package com.xkt.students_project_spring_boot.domain;

import java.io.Serializable;
import java.util.Date;

public class Poor implements Serializable{
//    贫困生申请id
    private Integer poorId;
//    批准理由
    private String reviewReason;
//    申请理由
    private String reason;
//    学生id
    private Integer stuId;
//    学生姓名
    private String stuName;
//    审核老师id
    private Integer teaId;
//    申请日期
    private Date applyForDate;
//    审核日期
    private Date reviewDate;
//    是否单亲
    private Integer subsidy;
//    是否享有国家救助
    private Integer singleParent;
//    状态
    private String state;

    public Integer getPoorId() {
        return poorId;
    }

    public void setPoorId(Integer poorId) {
        this.poorId = poorId;
    }

    public String getReviewReason() {
        return reviewReason;
    }

    public void setReviewReason(String reviewReason) {
        this.reviewReason = reviewReason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public Date getApplyForDate() {
        return applyForDate;
    }

    public void setApplyForDate(Date applyForDate) {
        this.applyForDate = applyForDate;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Integer getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(Integer subsidy) {
        this.subsidy = subsidy;
    }

    public Integer getSingleParent() {
        return singleParent;
    }

    public void setSingleParent(Integer singleParent) {
        this.singleParent = singleParent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Poor{" +
                "poorId=" + poorId +
                ", reviewReason='" + reviewReason + '\'' +
                ", reason='" + reason + '\'' +
                ", stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", teaId=" + teaId +
                ", applyForDate=" + applyForDate +
                ", reviewDate=" + reviewDate +
                ", subsidy=" + subsidy +
                ", singleParent=" + singleParent +
                ", state='" + state + '\'' +
                '}';
    }
}
