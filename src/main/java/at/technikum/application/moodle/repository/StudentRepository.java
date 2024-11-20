package at.technikum.application.moodle.repository;

import at.technikum.application.moodle.entity.Student;

import java.util.List;

public interface StudentRepository {

    Student save(Student student);

    List<Student> findAll();
}
