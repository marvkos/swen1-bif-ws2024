package at.technikum;

import at.technikum.application.moodle.Moodle;
import at.technikum.server.Server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(new Moodle());
        server.start();
    }
}
