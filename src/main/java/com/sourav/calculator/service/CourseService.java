package com.sourav.calculator.service;

import com.sourav.calculator.model.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourses();

    public Course getCourse(Long id);

    public Course saveCourse(Course course);

    public void deleteCourse(Long id);
}
