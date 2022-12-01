package com.sourav.calculator.controller;

import com.sourav.calculator.model.Grade;
import com.sourav.calculator.service.GradeService;
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
public class GradeController {

    @Autowired
    @Qualifier("gradeServiceImpl")
    GradeService gradeService;

    @GetMapping("/grades")
    //@ResponseStatus(HttpStatus.BAD_GATEWAY)
    public Optional<Grade> getGrades(@RequestParam(required = false) String name) {
        Optional<Grade> grade = Optional.ofNullable(gradeService.findBy(name));
        return grade;
    }

    @GetMapping("/grades/all")
    //@ResponseStatus(HttpStatus.BAD_GATEWAY)
    public List<Grade> getGrades() {
        return gradeService.getGrades();
    }

    @GetMapping("/grades/{name}")
    //@ResponseStatus(HttpStatus.BAD_GATEWAY)
    public Optional<Grade> getGradesByName(@PathVariable String name) {
        Optional<Grade> grade = Optional.ofNullable(gradeService.findBy(name));
        return grade;
    }

    @PostMapping("/grades")
    public String submitGrades(@Valid @RequestBody Grade grade, BindingResult result) {
        System.out.println(result.hasErrors());
//        if(grade.getDiscount() > grade.getPrice())
//            result.rejectValue("price", "4xx", "Invalid");
        System.out.println(result.hasErrors());
        return gradeService.handleSubmit(grade);
    }

    @PostMapping("/grades/v1")
    public ResponseEntity<Grade> submitGrades1(@Valid @RequestBody Grade grade, BindingResult result) {
        System.out.println(result.hasErrors());
//        if(grade.getDiscount() > grade.getPrice())
//            result.rejectValue("price", "4xx", "Invalid");
        if(!result.hasErrors())
            gradeService.handleSubmit(grade);
        return new ResponseEntity<>(HttpStatus.CREATED);
        //return ResponseEntity.status().body();
    }

    @PutMapping("/grades/{id}")
    public ResponseEntity<Grade> updateGrade (@PathVariable String id, @RequestBody Grade grade) {
        gradeService.updateGrade(id, grade);
        return new ResponseEntity<>(grade, HttpStatus.OK);
    }
}
