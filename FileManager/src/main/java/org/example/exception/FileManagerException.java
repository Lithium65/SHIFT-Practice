package org.example.exception;

import java.io.IOException;

public class FileManagerException extends IOException {
    public FileManagerException(String message) {
        super(message);
    }
}
