package core;

public enum StatusCode {
    SUCCESS(200, "200 OK: The request was successful"),
    CREATED(201, "201 Created: The request has been fulfilled, and a new resource has been created"),
    BAD_REQUEST(400, "400 Bad Request: The server cannot understand the request, typically due to a client error"),
    UNAUTHORIZED(401, "401 Unauthorized: INVALID ACCESS TOKEN"),
    NOT_FOUND(404, "404 Not Found: The server could not find the requested resource"),
    NO_CONTENT(204, "204 No Content: The server successfully processed the request, but there is no content to send in the response");

    public final int code;
    public final String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


}

