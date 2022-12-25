package com.sourav.calculator.service;

import com.sourav.calculator.model.Grade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface GradeService {
    List<Grade> getGrades();

    Optional<Grade> findBy(String name);

    Grade handleSubmit(Grade grade);

    void updateGrade(String id, Grade grade);

    void deleteGrade(String id);
}
