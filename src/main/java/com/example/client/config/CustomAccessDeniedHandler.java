package com.example.client.config;

import com.example.client.exception.ClientServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomAccessDeniedHandler extends OAuth2AccessDeniedHandler {

    private WebResponseExceptionTranslator exceptionTranslator = new DefaultWebResponseExceptionTranslator();

    private OAuth2ExceptionRenderer exceptionRenderer = new DefaultOAuth2ExceptionRenderer();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) {
        try {
            ResponseEntity<OAuth2Exception> result = exceptionTranslator.translate(authException);
            result = enhanceResponse(result, authException);
            exceptionRenderer.handleHttpEntityResponse(result, new ServletWebRequest(request, response));
        } catch (Exception e) {
            throw new ClientServiceException(e.getMessage());
        }
    }

}