package at.technikum.application.moodle;

import at.technikum.application.moodle.controller.Controller;
import at.technikum.application.moodle.controller.HealthController;
import at.technikum.application.moodle.controller.StudentController;
import at.technikum.application.moodle.controller.WaitController;
import at.technikum.application.moodle.data.ConnectionPool;
import at.technikum.application.moodle.repository.StudentDbRepository;
import at.technikum.application.moodle.repository.StudentRepository;
import at.technikum.application.moodle.exception.ControllerNotFoundException;
import at.technikum.application.moodle.routing.Router;
import at.technikum.application.moodle.service.StudentService;
import at.technikum.server.Application;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;
import at.technikum.server.http.Status;

public class Moodle implements Application {

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
            // TODO: better exception handling, map exception to http code?
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
        ConnectionPool connectionPool = new ConnectionPool();

        StudentRepository studentRepository = new StudentDbRepository(connectionPool);
        StudentService studentService = new StudentService(studentRepository);

        this.router.addRoute("/students", new StudentController(studentService));
        this.router.addRoute("/wait", new WaitController());
        this.router.addRoute("/health", new HealthController());
    }
}
