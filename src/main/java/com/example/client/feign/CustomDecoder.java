package com.example.client.feign;

import feign.Response;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomDecoder {

    @Autowired
    private Decoder decoder;

    @SuppressWarnings("unchecked")
    public <T> T asObject(Response response, Class<T> clazz) throws IOException {
        return (T) decoder.decode(response, clazz);
    }

}
