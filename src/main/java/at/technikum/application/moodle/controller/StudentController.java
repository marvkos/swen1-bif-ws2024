package at.technikum.application.moodle.controller;

import at.technikum.application.moodle.entity.Student;
import at.technikum.application.moodle.service.StudentService;
import at.technikum.server.http.Method;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;
import at.technikum.server.http.Status;

import java.util.List;

public class StudentController extends Controller {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @Override
    public Response handle(Request request) {

        if (request.getMethod().equals(Method.POST)) {
            return create(request);
        }
        if (request.getMethod().equals(Method.GET)) {
            return readAll();
        }

        // TODO: fix null return, should result in 405
        return null;
    }

    private Response create(Request request) {

        // request --> student
        Student student = fromBody(request.getBody(), Student.class);
        student = studentService.create(student);

        return json(Status.CREATED, student);
    }

    private Response readAll() {
        List<Student> students = studentService.getAll();

        return json(Status.OK, students);
    }
}
