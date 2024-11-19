package at.technikum.application.moodle.routing;

public class ControllerNotFound extends RuntimeException {
    public ControllerNotFound(String message) {
        super(message);
    }
}
