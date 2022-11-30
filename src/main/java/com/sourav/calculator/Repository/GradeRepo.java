package com.sourav.calculator.Repository;

import com.sourav.calculator.constant.GradeConstant;
import com.sourav.calculator.model.Grade;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GradeRepo {
    List<Grade> grades = new ArrayList<>();

    public Grade findBy(String name) {
        for(Grade grade: getGrades()) {
            if(grade.getName().equals(name))
                return grade;
        }
        return null;
    }

    public void addGrades(Grade grade) {
        grades.add(grade);
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void updateGrade(int index, Grade grade) {
        grades.set(index, grade);
    }
    public Grade getGrades(int index) {
        return grades.get(index);
    }

}
