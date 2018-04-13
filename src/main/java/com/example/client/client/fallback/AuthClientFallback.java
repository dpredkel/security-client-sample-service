package com.example.client.client.fallback;

import com.example.client.client.AuthClient;
import com.example.client.exception.CommonErrorDetail;
import com.example.client.model.RegistrationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthClientFallback implements AuthClient {

    @Override
    public ResponseEntity<HttpStatus> create(RegistrationDTO dto) {
        log.error("{} Fallback! \nemail: {}", this.getClass(), dto.getEmail());
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @Override
    public ResponseEntity<HttpStatus> exc() {
        log.error("exc Fallback!");
//        throw new RuntimeException("test");
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @Override
    public ResponseEntity<HttpStatus> ok() {
        log.error("ok Fallback!");
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @Override
    public ResponseEntity<HttpStatus> err() throws Exception {
        log.error("err Fallback!");
//        throw new Exception("test");
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

}
