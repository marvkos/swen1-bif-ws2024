package at.technikum.application.moodle.service;

import at.technikum.application.moodle.entity.Grade;
import at.technikum.application.moodle.entity.Student;
import at.technikum.application.moodle.exception.EntityNotFoundException;
import at.technikum.application.moodle.repository.GradeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GradeServiceTest {

    @Test
    public void give_threeGrades_when_calcAverage_then_beAverage() {
        // Arrange
        GradeRepository gradeRepository = mock(GradeRepository.class);
        when(gradeRepository.findByStudent(any())).thenReturn(List.of(
                new Grade(1), new Grade(2), new Grade(3)
        ));
        GradeService gradeService = new GradeService(gradeRepository);

        Student student = new Student();

        // Act
        float avg = gradeService.calcAvgGrade(student);

        // Assert
        assertEquals(2.0f, avg);
        verify(gradeRepository, times(1)).findByStudent(student);

        /*
        assertThrows(
                EntityNotFoundException.class,
                () -> gradeService.calcAvgGrade(new Student())
        );
        */
    }

}
