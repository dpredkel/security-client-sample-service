package com.example.client.exception;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import lombok.Getter;
import lombok.Setter;

public class FeignBadRequestException extends HystrixBadRequestException {
    private static final long serialVersionUID = -3546950760063996428L;

    @Getter
    private int status;

    public FeignBadRequestException(String message) {
        super(message);
    }

    public FeignBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public FeignBadRequestException(String message, int status) {
        super(message);
        this.status = status;
    }

    public FeignBadRequestException(String s, Throwable cause, int status) {
        super(s, cause);
        this.status = status;
    }
}
