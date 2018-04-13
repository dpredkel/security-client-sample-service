package com.example.client.feign;

import com.example.client.exception.*;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Autowired
    private CustomDecoder decoder;

    /**
     * Implement this method in order to decode an HTTP {@link Response} when {@link
     * Response#status()} is not in the 2xx range.
     *
     * Please raise application-specific exceptions where possible.
     *
     * It's need to test this statement:
     * If your exception is retryable, wrap or subclass {@link RetryableException}
     *
     * ALL Exceptions will invoke fallback methods except {@link HystrixBadRequestException} and subclasses.
     *
     * @param methodKey {@link feign.Feign#configKey} of the java method that invoked the request.
     *                  ex. {@code IAM#getUser()}
     * @param response  HTTP response where {@link Response#status() status} is greater than or equal
     *                  to {@code 300}.
     * @return Exception IOException, if there was a network error reading the response or an
     * application-specific exception decoded by the implementation. If the throwable is retryable, it
     * should be wrapped, or a subtype of {@link RetryableException}
     */

    @Override
    public Exception decode(String methodKey, Response response) {
//        log.error("Method: {}, Response status: {}, Reason: {}, \nRequest: {}", methodKey, response.status(), response.reason(), response.request());
        if (response.status() == 401 || response.status() == 403) {
            return new ClientServiceException(methodKey, response.status());
        }
        if (response.status() >= 400 && response.status() <= 499) {
            CommonErrorDetail detail;
            try {
                detail = decoder.asObject(response, CommonErrorDetail.class);
            } catch (IOException e) {
                return new ClientServiceException(response.reason(), response.status());
            }
            return new FeignBadRequestException(detail.getDetail(), detail.getStatus());
//            return new RetryableException("message", new Date(System.currentTimeMillis()+15000));
        }
        if (response.status() >= 500 && response.status() <= 599) {
            return new ClientServiceException(response.reason(), response.status());
        }
        return new ClientServiceException(response.reason());
    }
}
