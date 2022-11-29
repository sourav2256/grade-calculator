package com.sourav.calculator.service;

import com.sourav.calculator.Repository.GradeRepo;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {

    @Mock
    private GradeRepo gradeRepo;

    @InjectMocks
    private GradeService gradeService;
}
