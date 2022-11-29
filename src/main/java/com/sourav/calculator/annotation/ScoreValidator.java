package com.sourav.calculator.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class ScoreValidator implements ConstraintValidator<Score, String> {

    List<String> scores = Arrays.asList("A", "B", "C");

    @Override
    public void initialize(Score constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String score, ConstraintValidatorContext constraintValidatorContext) {
        for (String s: scores) {
            if(s.equals(score))
                return false;
        }
        return true;
    }


}
