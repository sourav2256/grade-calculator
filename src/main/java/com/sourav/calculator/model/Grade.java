package com.sourav.calculator.model;

import com.sourav.calculator.annotation.Score;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.UUID;

public class Grade {

    private String name;
    @Min(value = 20, message = "min")
    @Score
    private String score;
    private String subject;
    @Max(value = 100, message = "can not exceed 100")
    private int fullMarks;

    private String id;

    public Grade(String name, String score, String subject, int fullMarks) {
        this.name = name;
        this.score = score;
        this.subject = subject;
        this.fullMarks = fullMarks;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFullMarks() {
        return fullMarks;
    }

    public void setFullMarks(int fullMarks) {
        this.fullMarks = fullMarks;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", subject='" + subject + '\'' +
                '}';
    }
}
