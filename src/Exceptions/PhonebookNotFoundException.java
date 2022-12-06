package Exceptions;

public class PhonebookNotFoundException extends RuntimeException {

    public PhonebookNotFoundException() {
    }

    public PhonebookNotFoundException(String message) {
        super(message);
    }

    public PhonebookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhonebookNotFoundException(Throwable cause) {
        super(cause);
    }

    public PhonebookNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
