package com.sourav.calculator.service;

import com.sourav.calculator.Repository.GradeRepo;
import com.sourav.calculator.constant.GradeConstant;
import com.sourav.calculator.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("gradeServiceImpl")
@ConditionalOnProperty(name = "server.port", havingValue = "8080")
//@Primary
public class GradeServiceImpl implements GradeService{

    @Autowired
    GradeRepo gradeRepo;
    public GradeServiceImpl(GradeRepo gradeRepo) {
        this.gradeRepo = gradeRepo;
        System.out.println("#####");
    }
    public Optional<Grade> findBy(String name) {
        return Optional.ofNullable(gradeRepo.findBy(name));
    }
    public void add(Grade grade) {
        gradeRepo.addGrades(grade);
    }


    public List<Grade> getGrades() {
        return gradeRepo.getGrades();
    }

    public Grade handleSubmit(Grade grade) {
        Optional<Grade> getGrade = findBy(grade.getName());
        String status = GradeConstant.FAILED_STATUS;;
        if(getGrade == null) {
            add(grade);
            status = GradeConstant.SUCCESS_STATUS;
        }
        return grade;
    }

    public void updateGrade(String id, Grade grade) {
        gradeRepo.updateGrade(getGradeIndex(id), grade);
    }

    @Override
    public void deleteGrade(String id) {
        gradeRepo.deleteGrade(id);
    }

    public int getGradeIndex(String id) {
        for (int i = 0; i < getGrades().size(); i++) {
            if (getGrades().get(i).getId().equals(id)) return i;
        }
        return GradeConstant.NOT_FOUND;
    }

    public String handleSubmit1(Grade grade) {
        int index = getGradeIndex(grade.getId());
        String status = GradeConstant.FAILED_STATUS;;
        if(index == GradeConstant.NOT_FOUND) {
            add(grade);
            status = GradeConstant.SUCCESS_STATUS;
        }
        else {
            gradeRepo.updateGrade(index, grade);
        }
        return status+grade;
    }
}
