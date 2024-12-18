package at.technikum.application.moodle.controller;

import at.technikum.application.moodle.dto.Message;
import at.technikum.server.http.Request;
import at.technikum.server.http.Response;
import at.technikum.server.http.Status;

import java.time.Duration;

public class WaitController extends Controller {

    @Override
    public Response handle(Request request) {

        try {
            Thread.sleep(Duration.ofSeconds(10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return json(Status.OK, new Message("wait"));
    }
}
