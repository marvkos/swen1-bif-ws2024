package at.technikum.application.moodle.service;

import at.technikum.application.moodle.entity.Student;
import at.technikum.application.moodle.exception.EntityNotFoundException;
import at.technikum.application.moodle.repository.StudentRepository;

import java.util.List;
import java.util.UUID;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(Student student) {
        // validate data
        // does student already exist
        student.setId(UUID.randomUUID().toString());
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
