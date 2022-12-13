package com.sourav.calculator.Repository;

import com.sourav.calculator.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepo extends CrudRepository<Course, Long> {
}

