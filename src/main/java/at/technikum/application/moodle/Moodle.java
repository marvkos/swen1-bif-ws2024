package at.technikum.application.moodle;

import at.technikum.application.moodle.controller.StudentController;
import at.technikum.server.Application;
import at.technikum.server.http.Method;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;
import at.technikum.server.http.Status;

public class Moodle implements Application {

    private final StudentController studentController = new StudentController();

    @Override
    public Response handle(Request request) {

        if (
                request.getPath().startsWith("/students")
                && request.getMethod() == Method.POST
        ) {
            return studentController.create(request);
        }

        Response response = new Response();
        response.setStatus(Status.NOT_FOUND);

        response.setHeader("Content-Type", "application/json");
        response.setBody(
                "{\"error\": \"Path: %s not found\" }"
                        .formatted(request.getPath())
        );

        return response;
    }
}
