package isp.lab7.safehome;

public class TooManyAttemptsException extends Exception {
    TooManyAttemptsException(String message) {
        super(message);
    }
}
