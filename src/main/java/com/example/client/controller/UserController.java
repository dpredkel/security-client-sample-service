package com.example.client.controller;

import com.example.client.client.AuthClient;
import com.example.client.exception.FeignBadRequestException;
import com.example.client.model.RegistrationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthClient authClient;

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody RegistrationDTO dto) {
        ResponseEntity<HttpStatus> response;
        try {
            response = authClient.create(dto);
        } catch (FeignBadRequestException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.valueOf(e.getStatus()));
        }
        return new ResponseEntity<>(response.getStatusCode());
    }

    @GetMapping("/exc")
    public ResponseEntity<HttpStatus> exc() {
        try {
            return authClient.exc();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @GetMapping("/ok")
    public ResponseEntity<HttpStatus> ok() {
        try {
            return authClient.ok();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @GetMapping("/err")
    public ResponseEntity<HttpStatus> err() {
        try {
            return authClient.err();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
