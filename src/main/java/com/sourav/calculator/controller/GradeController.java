package com.sourav.calculator.controller;

import com.sourav.calculator.model.Grade;
import com.sourav.calculator.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GradeController {

    @Autowired
    GradeService gradeService;

    @GetMapping("/grades")
    //@ResponseStatus(HttpStatus.BAD_GATEWAY)
    public Optional<Grade> getGrades(@RequestParam(required = false) String name) {
        Optional<Grade> grade = Optional.ofNullable(gradeService.findBy(name));
        return grade;
    }

    @GetMapping("/grades/v1")
    //@ResponseStatus(HttpStatus.BAD_GATEWAY)
    public List<Grade> getGrades() {
        return gradeService.getData();
    }

    @GetMapping("/grades/{name}")
    //@ResponseStatus(HttpStatus.BAD_GATEWAY)
    public Optional<Grade> getGradesByName(@PathVariable String name) {
        Optional<Grade> grade = Optional.ofNullable(gradeService.findBy(name));
        return grade;
    }

    @PostMapping("/grades")
    public String postGrades(@Valid @RequestBody Grade grade, BindingResult result) {
        System.out.println(result.hasErrors());
//        if(grade.getDiscount() > grade.getPrice())
//            result.rejectValue("price", "4xx", "Invalid");
        System.out.println(result.hasErrors());
        return gradeService.handleSubmit(grade);
    }
}
