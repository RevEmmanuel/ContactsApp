package Exceptions;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException() {
    }

    public ContactNotFoundException(String message) {
        super(message);
    }

    public ContactNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContactNotFoundException(Throwable cause) {
        super(cause);
    }
}
