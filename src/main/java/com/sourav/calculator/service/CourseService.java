package com.sourav.calculator.service;

import com.sourav.calculator.model.Course;
import com.sourav.calculator.model.Grade;

import java.util.List;

public interface CourseService {
    public List<Course> getCourse(Long Id);

    public Course saveCourse(Course course);

    public Course updateCourse();
}
