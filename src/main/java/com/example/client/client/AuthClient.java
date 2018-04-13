package com.example.client.client;

import com.example.client.client.fallback.AuthClientFallback;
import com.example.client.model.RegistrationDTO;
import feign.Headers;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Headers("Accept: application/json")
@FeignClient(name = "${feign.name.auth}", path = "/uaa/user", fallback = AuthClientFallback.class)
public interface AuthClient {

    @PostMapping
    ResponseEntity<HttpStatus> create(RegistrationDTO dto);

    @GetMapping("/exc")
    ResponseEntity<HttpStatus> exc();

    @GetMapping("/ok")
    ResponseEntity<HttpStatus> ok();

    @GetMapping("/err")
    ResponseEntity<HttpStatus> err() throws Exception;

}
