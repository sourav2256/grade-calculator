package com.sourav.calculator;


import com.sourav.calculator.Repository.GradeRepo;
import com.sourav.calculator.Repository.StudentRepo;
import com.sourav.calculator.model.Grade;
import com.sourav.calculator.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class GradeCalculatorApplication implements CommandLineRunner {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    GradeRepo gradeRepo;
    public static void main(String[] args) {
        SpringApplication.run(GradeCalculatorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student[] students = new Student[] {
                new Student("Harry Potter", LocalDate.parse(("1980-07-31"))),
                new Student("Ron Weasley", LocalDate.parse(("1980-03-01"))),
                new Student("Hermione Granger", LocalDate.parse(("1979-09-19"))),
                new Student("Neville Longbottom", LocalDate.parse(("1980-07-30")))
        };

        for (int i = 0; i < students.length; i++) {
            studentRepo.save(students[i]);
        }

        Grade grade = new Grade(1L, "A+", students[0]);
        gradeRepo.save(grade);
    }
}
