package at.technikum;

import at.technikum.server.http.Request;

public class Main {
    public static void main(String[] args) {
        // Start server

        Request req = new Request();
        req.setMethod("GET");

        System.out.println(req.getMethod());
    }
}
