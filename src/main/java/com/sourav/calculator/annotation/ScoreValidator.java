package com.sourav.calculator.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
