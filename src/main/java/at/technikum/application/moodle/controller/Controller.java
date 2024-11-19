package at.technikum.application.moodle.controller;

import at.technikum.server.http.Request;
import at.technikum.server.http.Response;

public abstract class Controller {

    public abstract Response handle(Request request);
}
