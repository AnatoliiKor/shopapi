package com.kor.shopapi.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Counter {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Integer correctAnswers;
    private Double time;
    private LocalDate localDate;
    private Integer succes;

    public Counter() {
        this.setLocalDate();
    }

    public Counter(Integer correctAnswers, int time, Integer succes) {
        this.correctAnswers = correctAnswers;
        this.time = (double) time/60;
        this.succes = succes;
        this.setLocalDate();
    }

    public Integer getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(Integer correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate() {
        this.localDate = LocalDate.now();
    }

    public Integer getSucces() {
        return succes;
    }

    public void setSucces(Integer succes) {
        this.succes = succes;
    }


}
