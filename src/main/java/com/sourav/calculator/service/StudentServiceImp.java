package com.sourav.calculator.service;

import com.sourav.calculator.Repository.StudentRepo;
import com.sourav.calculator.model.Grade;
import com.sourav.calculator.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    StudentRepo studentRepo;


    @Override
    public Student getStudent(Long id) {
        printGrades(studentRepo.findById(id).get());
        return studentRepo.findById(id).get();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public List<Student> getStudents() {
        return (List<Student>) studentRepo.findAll();
    }

    public void printGrades(Student student) {
        for (Grade grade: student.getGrades()) {
            System.out.println(grade.getScore());
        }
    }

}
