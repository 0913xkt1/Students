package com.xkt.students_project_spring_boot.domain;

import java.io.Serializable;
import java.util.Date;

public class Score implements Serializable {
//    分数表id
    private Integer scoreId;
//    考试日期
    private Date scoreDate;
//    学生id
    private Integer stuId;
//    教室id
    private Integer classId;
//    年纪
    private String grade;
//    分数
    private Double score;
//    科目
    private String scoreName;
//学生姓名
    private String stuName;

    public String getStuName() {
        return stuName;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId +
                ", scoreDate=" + scoreDate +
                ", stuId=" + stuId +
                ", classId=" + classId +
                ", grade='" + grade + '\'' +
                ", score=" + score +
                ", scoreName='" + scoreName + '\'' +
                ", stuName='" + stuName + '\'' +
                '}';
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Date getScoreDate() {
        return scoreDate;
    }

    public void setScoreDate(Date scoreDate) {
        this.scoreDate = scoreDate;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getScoreName() {
        return scoreName;
    }

    public void setScoreName(String scoreName) {
        this.scoreName = scoreName;
    }

}
