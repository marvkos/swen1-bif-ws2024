package at.technikum.server.http;

public enum Method {

    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE");

    private final String name;

    Method(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
