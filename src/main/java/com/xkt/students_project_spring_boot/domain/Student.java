package com.xkt.students_project_spring_boot.domain;

import java.io.Serializable;

public class Student implements Serializable {
//    学生id
    private Integer stuId;
//    密码
    private String password;
//    班级id
    private Integer classId;
//    年级
    private String grade;
//    宿舍号
    private Integer dormId;
//    是否单亲
    private Integer singleParent;
//    是否享受国家补助
    private Integer subsidy;
//    家长id
    private Integer patriarchId;
//    学生姓名
    private String stuName;
//    性别
    private String sex;
//    登录权限
    private Integer loginAutority;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getDormId() {
        return dormId;
    }

    public void setDormId(Integer dormId) {
        this.dormId = dormId;
    }

    public Integer getSingleParent() {
        return singleParent;
    }

    public void setSingleParent(Integer singleParent) {
        this.singleParent = singleParent;
    }

    public Integer getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(Integer subsidy) {
        this.subsidy = subsidy;
    }

    public Integer getPatriarchId() {
        return patriarchId;
    }

    public void setPatriarchId(Integer patriarchId) {
        this.patriarchId = patriarchId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", password='" + password + '\'' +
                ", classId=" + classId +
                ", grade='" + grade + '\'' +
                ", dormId=" + dormId +
                ", singleParent=" + singleParent +
                ", subsidy=" + subsidy +
                ", patriarchId=" + patriarchId +
                ", stuName='" + stuName + '\'' +
                ", sex='" + sex + '\'' +
                ", loginAutority=" + loginAutority +
                '}';
    }

    public Integer getLoginAutority() {
        return loginAutority;
    }

    public void setLoginAutority(Integer loginAutority) {
        this.loginAutority = loginAutority;
    }
}
