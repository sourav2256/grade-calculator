package com.sourav.calculator.Repository;

import com.sourav.calculator.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Long> {
}
