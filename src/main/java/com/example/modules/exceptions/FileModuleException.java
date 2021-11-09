package com.example.modules.exceptions;

public class FileModuleException extends ApplicationException {

    public FileModuleException(String message) {
        super(message);
    }

    public FileModuleException(Throwable cause) {
        super(cause);
    }
}
