package com.xkt.students_project_spring_boot.domain;

import java.io.Serializable;

public class CollectScore implements Serializable {
//    总分数
    private Double grossScore;
//平均分
    private Double avgScore;

    public Double getGrossScore() {
        return grossScore;
    }

    public void setGrossScore(Double grossScore) {
        this.grossScore = grossScore;
    }

    public Double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Double avgScore) {
        this.avgScore = avgScore;
    }

    @Override
    public String toString() {
        return "CollectScore{" +
                "grossScore=" + grossScore +
                ", avgScore=" + avgScore +
                '}';
    }
}
