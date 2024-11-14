package at.technikum.application.moodle.repository;

import at.technikum.application.moodle.entity.Student;

public interface StudentRepository {

    Student save(Student student);
}
