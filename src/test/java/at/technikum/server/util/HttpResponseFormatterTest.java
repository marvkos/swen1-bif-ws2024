package at.technikum.server.util;

import at.technikum.server.http.Response;
import at.technikum.server.http.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpResponseFormatterTest {

    private final HttpResponseFormatter httpResponseFormatter = new HttpResponseFormatter();

    @Test
    public void give_statusOk_then_formatStatusLineCorrectly() {
        Response response = new Response();
        response.setStatus(Status.OK);

        String http = httpResponseFormatter.format(response);

        assertTrue(http.startsWith("HTTP/1.1 200 OK\r\n"));
    }

    @Test
    public void give_statusInternalServerError_then_formatStatusLineCorrectly() {
        Response response = new Response();
        response.setStatus(Status.INTERNAL_SERVER_ERROR);

        String http = httpResponseFormatter.format(response);

        assertTrue(http.startsWith("HTTP/1.1 500 Internal Server Error\r\n"));
    }

    @Test
    public void give_authenticationHeader_then_formatHeaderCorrectly() {
        Response response = new Response();
        response.setStatus(Status.OK);
        response.setHeader("Authentication", "Bearer example-token");

        String http = httpResponseFormatter.format(response);

        assertTrue(http.contains("Authentication: Bearer example-token\r\n"));
    }

    @Test
    public void give_body_then_formatContentLengthCorrectly() {
        Response response = new Response();
        response.setStatus(Status.INTERNAL_SERVER_ERROR);
        response.setHeader("Content-Type", "application/json");
        String body = "{ \"message\": \"Internal Server Error\" }";
        response.setBody(body);

        String http = httpResponseFormatter.format(response);

        assertTrue(
                http.contains("Content-Length: %s\r\n".formatted(body.length()))
        );
    }

    @Test
    public void give_body_then_formatBodyCorrectly() {
        Response response = new Response();
        response.setStatus(Status.INTERNAL_SERVER_ERROR);
        response.setHeader("Content-Type", "application/json");
        String body = "{ \"message\": \"Internal Server Error\" }";
        response.setBody(body);

        String http = httpResponseFormatter.format(response);

        assertTrue(http.contains(body));
    }

    @Test
    public void give_body_then_formatEmptyLineCorrectly() {
        Response response = new Response();
        response.setStatus(Status.INTERNAL_SERVER_ERROR);
        response.setHeader("Content-Type", "application/json");
        String body = "{ \"message\": \"Internal Server Error\" }";
        response.setBody(body);

        String http = httpResponseFormatter.format(response);

        assertTrue(http.contains("\r\n%s".formatted(body)));
    }

    @Test
    public void give_noStatus_then_noHttpStatusException() {
        Response response = new Response();

        assertThrows(
                NoHttpStatusException.class,
                () -> httpResponseFormatter.format(response)
        );
    }
}
