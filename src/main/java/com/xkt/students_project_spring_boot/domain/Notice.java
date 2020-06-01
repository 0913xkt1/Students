package com.xkt.students_project_spring_boot.domain;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {
    private Integer noticeId;
    private Date noticeDate;
    private String noticeTitle;
    private String noticeBody;
    private String noticeType;
    private String author;
    private Integer classId;

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId=" + noticeId +
                ", noticeDate=" + noticeDate +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeBody='" + noticeBody + '\'' +
                ", noticeType='" + noticeType + '\'' +
                ", author='" + author + '\'' +
                ", classId=" + classId +
                '}';
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeBody() {
        return noticeBody;
    }

    public void setNoticeBody(String noticeBody) {
        this.noticeBody = noticeBody;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}
