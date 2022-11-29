package com.sourav.calculator.Repository;

import com.sourav.calculator.constant.GradeConstant;
import com.sourav.calculator.model.Grade;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GradeRepo {
    List<Grade> lists = new ArrayList<>();

    public Grade findBy(String name) {
        for(Grade grade: getGrades()) {
            if(grade.getName().equals(name))
                return grade;
        }
        return null;
    }

    public void add(Grade grade) {
        lists.add(grade);
    }

    public List<Grade> getGrades() {
        return lists;
    }

}
