package at.technikum.application.moodle;

import at.technikum.application.moodle.controller.Controller;
import at.technikum.application.moodle.controller.StudentController;
import at.technikum.application.moodle.routing.ControllerNotFoundException;
import at.technikum.application.moodle.routing.Router;
import at.technikum.server.Application;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;
import at.technikum.server.http.Status;

public class Moodle implements Application {

    private final StudentController studentController = new StudentController();

    private final Router router;

    public Moodle() {
        this.router = new Router();

        this.initializeRoutes();
    }

    @Override
    public Response handle(Request request) {

        try {
            Controller controller
                    = this.router.getController(request.getPath());
            return controller.handle(request);

        } catch (ControllerNotFoundException e) {
            Response response = new Response();
            response.setStatus(Status.NOT_FOUND);

            response.setHeader("Content-Type", "application/json");
            response.setBody(
                    "{\"error\": \"Path: %s not found\" }"
                            .formatted(e.getMessage())
            );

            return response;
        }
    }

    private void initializeRoutes() {
        this.router.addRoute("/students", new StudentController());
    }
}
