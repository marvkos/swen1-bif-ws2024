package at.technikum.application.moodle.repository;

import at.technikum.application.moodle.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentMemoryRepository implements StudentRepository {

    private final List<Student> students;

    public StudentMemoryRepository() {
        this.students = new ArrayList<>();
    }

    @Override
    public Student save(Student student) {
        student.setId(String.valueOf(this.students.size() + 1));
        this.students.add(student);

        return student;
    }

    @Override
    public List<Student> findAll() {
        return this.students;
    }

    @Override
    public Optional<Student> find(int id) {
        return Optional.empty();
    }

    @Override
    public Student delete(Student student) {
        return null;
    }
}
