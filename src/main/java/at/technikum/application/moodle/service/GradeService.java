package at.technikum.application.moodle.service;

import at.technikum.application.moodle.entity.Grade;
import at.technikum.application.moodle.entity.Student;
import at.technikum.application.moodle.repository.GradeRepository;

import java.util.List;

public class GradeService {

    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public float calcAvgGrade(Student student) {
        List<Grade> grades = gradeRepository.findByStudent(student);

        float total = 0;
        for (Grade grade: grades) {
            total += grade.getGrade();
        }

        return total / grades.size();
    }
}
