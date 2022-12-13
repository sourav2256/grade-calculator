package com.sourav.calculator.service;

import com.sourav.calculator.model.Student;

import java.util.List;

public interface StudentService {
    public Student getStudent(Long id);
    public Student saveStudent(Student student);
    public void deleteStudent(Long id);

    public List<Student> getStudents();
}
