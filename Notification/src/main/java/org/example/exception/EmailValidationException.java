package org.example.exception;

public class EmailValidationException extends NotificationValidationException {


    public EmailValidationException(String message) {
        super(message);
    }

    public EmailValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
