package com.xkt.students_project_spring_boot.domain;

import java.io.Serializable;

public class Admin implements Serializable {
//    主键
    private Integer adminID;
//    登录权限
    private Integer loginAutority;
//    密码
    private String password;

    public Integer getAdminID() {
        return adminID;
    }

    public void setAdminID(Integer adminID) {
        this.adminID = adminID;
    }

    public Integer getLoginAutority() {
        return loginAutority;
    }

    public void setLoginAutority(Integer loginAutority) {
        this.loginAutority = loginAutority;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminID=" + adminID +
                ", loginAutority=" + loginAutority +
                ", password='" + password + '\'' +
                '}';
    }
}
