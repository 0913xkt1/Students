package com.xkt.students_project_spring_boot.domain;

import java.io.Serializable;

public class Teacher implements Serializable {
//    主键
    private Integer teacherId;
//    密码
    private String password;
//    权限
    private Integer autority;
//    登录权限
    private Integer loginAutority;
//    年级
    private String grade;
//    姓名
    private String teacherName;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAutority() {
        return autority;
    }

    public void setAutority(Integer autority) {
        this.autority = autority;
    }

    public Integer getLoginAutority() {
        return loginAutority;
    }

    public void setLoginAutority(Integer loginAutority) {
        this.loginAutority = loginAutority;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", password='" + password + '\'' +
                ", autority=" + autority +
                ", loginAutority=" + loginAutority +
                ", grade='" + grade + '\'' +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
