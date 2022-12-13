package com.sourav.calculator.service;

import com.sourav.calculator.Repository.CourseRepo;
import com.sourav.calculator.model.Course;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseServiceImp implements CourseService{

    CourseRepo courseRepo;

    @Override
    public List<Course> getCourse(Long Id) {
        return null;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Course updateCourse() {
        return null;
    }
}
