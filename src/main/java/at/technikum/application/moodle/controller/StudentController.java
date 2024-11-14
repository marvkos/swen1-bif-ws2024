package at.technikum.application.moodle.controller;

import at.technikum.application.moodle.entity.Student;
import at.technikum.application.moodle.service.StudentService;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;
import at.technikum.server.http.Status;

public class StudentController {

    private final StudentService studentService = new StudentService();

    public Response create(Request request) {

        // request --> student
        Student student = extractFromBody(request.getBody());
        student = studentService.create(student);

        Response response = new Response();
        response.setStatus(Status.CREATED);
        response.setHeader("Content-Type", "application/json");
        response.setBody(
                "{ \"studentId\": \"%s\" }"
                        .formatted(student.getId())
        );

        return response;
    }

    private Student extractFromBody(String body) {
        String firstName = "";
        String lastName = "";

        String[] lines = body.split("\n");
        for (String line : lines) {
            if (!line.contains(":")) {
                continue;
            }

            String[] keyValue = line.split(":");
            String key = keyValue[0].trim().replace("\"", "");
            String value = keyValue[1]
                    .trim()
                    .replace("\"", "")
                    .replace(",", "");

            if (key.equals("firstName")) {
                firstName = value;
            }
            if (key.equals("lastName")) {
                lastName = value;
            }
        }

        return new Student(firstName, lastName);
    }
}
