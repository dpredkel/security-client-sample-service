package com.example.client.exception;

import lombok.Getter;

public class ClientServiceException extends RuntimeException {
    private static final long serialVersionUID = 5263203139878102725L;

    @Getter
    private int status;

    public ClientServiceException(String message) {
        super(message);
    }

    public ClientServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientServiceException(String message, int status) {
        super(message);
        this.status = status;
    }

    public ClientServiceException(String s, Throwable cause, int status) {
        super(s, cause);
        this.status = status;
    }

}
