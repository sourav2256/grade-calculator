package com.sourav.calculator.service;

import com.sourav.calculator.Repository.GradeRepo;
import com.sourav.calculator.model.Grade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {

    @Mock
    private GradeRepo gradeRepo;

    @InjectMocks
    private GradeServiceImpl gradeService;

    // when the service calls gradeRepository.gerGrades(), then it should return a list of grades
    @Test
    public void getGradesFromRepoTest() {
        when(gradeRepo.getGrades()).thenReturn(Collections.singletonList(
                new Grade("Harry", "80", "DSA", 100)
        ));

        List<Grade> result = gradeService.getGrades();

        Assert.assertEquals("Harry", result.get(0).getName());
    }

    @Test
    public void findByNameTest() {
        Grade grade = new Grade("Harry", "80", "DSA", 100);
        when(gradeRepo.getGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepo.findBy(grade.getName())).thenReturn(grade);

        Grade valid = gradeService.findBy(grade.getName());
        Grade InValid = gradeService.findBy("123");
        Assert.assertEquals("Harry", valid.getName());
        Assert.assertEquals(null, InValid);
    }

    @Test
    public void addGradeTest() {

        Grade newGrade = new Grade("Sourav", "90", "DSA", 100);
        when(gradeRepo.getGrades()).thenReturn(Arrays.asList(newGrade));
        when(gradeRepo.findBy(newGrade.getName())).thenReturn(newGrade);

        gradeService.handleSubmit(newGrade);

        verify(gradeRepo, times(0)).addGrades(newGrade);
    }

    @Test
    public void updateGradeTest() {

        Grade newGrade = new Grade("Sourav", "90", "DSA", 100);
        when(gradeRepo.getGrades()).thenReturn(Arrays.asList(newGrade));
        when(gradeRepo.getGrades(0)).thenReturn(newGrade);

        gradeService.handleSubmit1(newGrade);

        verify(gradeRepo, times(1)).updateGrade(0, newGrade);
    }
}
