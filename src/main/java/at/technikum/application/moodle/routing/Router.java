package at.technikum.application.moodle.routing;

import at.technikum.application.moodle.controller.Controller;

import java.util.*;

public class Router {

    private final List<Route> routes;

    public Router() {
        this.routes = new ArrayList<>();
    }

    public Controller getController(String path) {
        for (Route route: this.routes) {
            if (!path.startsWith(route.getRoute())) {
                continue;
            }

            return route.getController();
        }

        throw new ControllerNotFoundException(path);
    }

    public void addRoute(String route, Controller controller) {
        this.routes.add(new Route(route, controller));
    }
}
