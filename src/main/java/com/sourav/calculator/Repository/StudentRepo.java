package com.sourav.calculator.Repository;

import com.sourav.calculator.model.Grade;
import com.sourav.calculator.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepo extends CrudRepository<Student, Long> {
}
