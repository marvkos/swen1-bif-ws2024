package at.technikum;

import at.technikum.application.echo.EchoApplication;
import at.technikum.application.html.SimpleHtmlApplication;
import at.technikum.application.moodle.Moodle;
import at.technikum.server.Server;
import at.technikum.server.http.Request;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(new Moodle());
        server.start();
    }
}
