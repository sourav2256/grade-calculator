package com.sourav.calculator.controller;

import com.sourav.calculator.Repository.StudentRepo;
import com.sourav.calculator.model.Grade;
import com.sourav.calculator.service.GradeService;
import com.sourav.calculator.service.GradeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/grades")
public class GradeController {

    @Autowired
    GradeServiceImpl gradeService;


    @GetMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<List<Grade>> getGrade(@PathVariable Long studentId, Long courseId) {
        return new ResponseEntity(gradeService.getGrades(studentId, courseId), HttpStatus.OK);
    }

    @PostMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> getGrade(@RequestBody Grade grade, @PathVariable Long studentId, Long courseId) {
        return new ResponseEntity<>(gradeService.saveGrade(grade, studentId, courseId), HttpStatus.CREATED);
    }
}
