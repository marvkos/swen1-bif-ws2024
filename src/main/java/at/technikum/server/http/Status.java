package at.technikum.server.http;

public enum Status {

    OK(200, "OK"),
    NOT_FOUND(404, "NOT FOUND");

    private final int code;
    private final String message;

    Status(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
