package com.xkt.students_project_spring_boot.domain;

import java.io.Serializable;

public class Patriarch implements Serializable {
//    家长号
    private Integer patId;
//    姓名
    private String patName;
//    性别
    private String sex;
//    手机号
    private String cellPhoneNumber;
//    登录权限
    private Integer loginAutority;
//    学号
    private Integer stuId;
//    密码
    private String password;

    public Integer getPatId() {
        return patId;
    }

    public void setPatId(Integer patId) {
        this.patId = patId;
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public Integer getLoginAutority() {
        return loginAutority;
    }

    public void setLoginAutority(Integer loginAutority) {
        this.loginAutority = loginAutority;
    }


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

    @Override
    public String toString() {
        return "Patriarch{" +
                "patId=" + patId +
                ", patName='" + patName + '\'' +
                ", sex='" + sex + '\'' +
                ", cellPhoneNumber='" + cellPhoneNumber + '\'' +
                ", loginAutority=" + loginAutority +
                ", stuId=" + stuId +
                ", password='" + password + '\'' +
                '}';
    }

}
