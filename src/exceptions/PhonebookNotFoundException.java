package exceptions;

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
}
