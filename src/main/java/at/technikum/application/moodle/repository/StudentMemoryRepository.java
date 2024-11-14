package at.technikum.application.moodle.repository;

import at.technikum.application.moodle.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMemoryRepository implements StudentRepository {

    private final List<Student> students;

    public StudentMemoryRepository() {
        this.students = new ArrayList<>();
    }

    @Override
    public Student save(Student student) {
        student.setId(this.students.size() + 1);
        this.students.add(student);

        return student;
    }
}
