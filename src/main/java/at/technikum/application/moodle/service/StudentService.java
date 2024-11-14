package at.technikum.application.moodle.service;

import at.technikum.application.moodle.entity.Student;
import at.technikum.application.moodle.repository.StudentMemoryRepository;
import at.technikum.application.moodle.repository.StudentRepository;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService() {
        this.studentRepository = new StudentMemoryRepository();
    }

    public Student create(Student student) {
        // validate data
        // does student already exist
        return studentRepository.save(student);
    }
}
