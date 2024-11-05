package at.technikum.server.http;

public class Request {

    private String method;

    public Request() {
        this.method = "GET";
    }

    public Request(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
