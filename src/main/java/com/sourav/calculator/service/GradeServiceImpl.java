package com.sourav.calculator.service;

import com.sourav.calculator.Repository.GradeRepo;
import com.sourav.calculator.Repository.StudentRepo;
import com.sourav.calculator.constant.GradeConstant;
import com.sourav.calculator.model.Grade;
import com.sourav.calculator.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("gradeServiceImpl")
@ConditionalOnProperty(name = "server.port", havingValue = "8080")
//@Primary
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeRepo gradeRepo;

    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Grade> getGrades(Long studentId, Long courseId) {
        return gradeRepo.findByStudentId(studentId);
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = studentRepo.findById(studentId).get();
        grade.setStudent(student);
        return gradeRepo.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        return null;
    }
}
