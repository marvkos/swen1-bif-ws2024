package at.technikum.application.moodle.controller;

import at.technikum.application.moodle.dto.Message;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;
import at.technikum.server.http.Status;

public class HealthController extends Controller {

    @Override
    public Response handle(Request request) {
        return json(Status.OK, new Message("health"));
    }
}
