package at.technikum.application.moodle.repository;

import at.technikum.application.moodle.entity.Grade;
import at.technikum.application.moodle.entity.Student;

import java.util.List;

public interface GradeRepository {

    List<Grade> findByStudent(Student student);
}
