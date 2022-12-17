package com.sourav.calculator;


import com.sourav.calculator.Repository.CourseRepo;
import com.sourav.calculator.Repository.GradeRepo;
import com.sourav.calculator.Repository.StudentRepo;
import com.sourav.calculator.model.Course;
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
    @Autowired
    CourseRepo courseRepo;
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

        Course[] courses = new Course[] {
                new Course("Charms", "CH104", "In this class, you will learn spells concerned with giving an object new and unexpected properties."),
                new Course("Defence Against the Dark Arts", "DADA", "In this class, you will learn defensive techniques against the dark arts."),
                new Course("Herbology", "HB311", "In this class, you will learn the study of magical plants and how to take care of, utilise and combat them."),
                new Course("History of Magic", "HIS393", "In this class, you will learn about significant events in wizarding history."),
                new Course("Potions", "POT102", "In this class, you will learn correct mixing and stirring of ingredients to create mixtures with magical effects."),
                new Course("Transfiguration", "TR442", "In this class, you will learn the art of changing the form or appearance of an object.")
        };

        for (int i = 0; i < students.length; i++) {
            studentRepo.save(students[i]);
        }

        for (int i = 0; i < courses.length; i++) {
            courseRepo.save(courses[i]);
        }

        Grade grade = new Grade(1L, "A+", students[0]);
        gradeRepo.save(grade);
    }
}
