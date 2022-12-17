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
    public List<Course> getCourses() {
        return (List<Course>) courseRepo.findAll();
    }

    @Override
    public Course getCourse(Long id) {
        return courseRepo.findById(id).get();
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }
}
