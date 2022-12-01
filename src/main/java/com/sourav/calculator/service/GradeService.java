package com.sourav.calculator.service;

import com.sourav.calculator.model.Grade;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GradeService {
    List<Grade> getGrades();

    Grade findBy(String name);

    String handleSubmit(Grade grade);

    void updateGrade(String id, Grade grade);
}
