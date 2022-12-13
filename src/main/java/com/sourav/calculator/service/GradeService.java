package com.sourav.calculator.service;

import com.sourav.calculator.model.Grade;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GradeService {
    public List<Grade> getGrades(Long studentId, Long courseId);

    public Grade saveGrade(Grade grade, Long studentId, Long courseId);

    public Grade updateGrade(String score, Long studentId, Long courseId);

}
