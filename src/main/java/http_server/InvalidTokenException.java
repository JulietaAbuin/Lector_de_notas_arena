package http_server;

public class InvalidTokenException extends Exception {

public InvalidTokenException() {
    super();
}

public InvalidTokenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
}

public InvalidTokenException(String message, Throwable cause) {
    super(message, cause);
}

public InvalidTokenException(String message) {
    super(message);
}

public InvalidTokenException(Throwable cause) {
    super(cause);
}
}
