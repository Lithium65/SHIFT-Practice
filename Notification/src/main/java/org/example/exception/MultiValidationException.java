package org.example.exception;

import java.util.List;

public class MultiValidationException extends RuntimeException {

    private List<ExceptionDto> exceptions;

    public MultiValidationException(String message) {
        super(message);
    }

    public MultiValidationException(List<ExceptionDto> exceptions) {
        this.exceptions = exceptions;
    }

    public List<ExceptionDto> getExceptions() {
        return exceptions;
    }
}
