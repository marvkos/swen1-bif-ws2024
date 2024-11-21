package at.technikum.application.moodle.service;

import at.technikum.application.moodle.entity.Student;
import at.technikum.application.moodle.exception.EntityNotFoundException;
import at.technikum.application.moodle.repository.StudentMemoryRepository;
import at.technikum.application.moodle.repository.StudentRepository;

import java.util.List;

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

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(int id) {
        return studentRepository.find(id)
                .orElseThrow(() -> new EntityNotFoundException(Student.class.getName(), id));
    }
}
