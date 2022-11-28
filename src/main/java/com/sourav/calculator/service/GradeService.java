package com.sourav.calculator.service;

import com.sourav.calculator.Repository.GradeRepo;
import com.sourav.calculator.constant.GradeConstant;
import com.sourav.calculator.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

//    @Autowired
    GradeRepo gradeRepo;
    public GradeService(GradeRepo gradeRepo) {
        this.gradeRepo = gradeRepo;
    }
    public Grade findBy(String name) {
        return gradeRepo.findBy(name);
    }

    public Grade findByName(String name) {
        for(Grade grade: gradeRepo.getData()) {
            if(grade.getName().equals(name))
                return grade;
        }
        return null;
    }

    public void add(Grade grade) {
        gradeRepo.add(grade);
    }


    public List<Grade> getData() {
        return gradeRepo.getData();
    }

    public String handleSubmit(Grade grade) {
        Grade getGrade = findByName(grade.getName());
        String status = GradeConstant.FAILED_STATUS;;
        if(getGrade == null) {
            add(grade);
            status = GradeConstant.SUCCESS_STATUS;
        }
        return status+grade;
    }
}
