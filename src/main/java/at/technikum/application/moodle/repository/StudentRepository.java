package at.technikum.application.moodle.repository;

import at.technikum.application.moodle.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    Student save(Student student);

    List<Student> findAll();

    Optional<Student> find(int id);

    Student delete(Student student);
}
