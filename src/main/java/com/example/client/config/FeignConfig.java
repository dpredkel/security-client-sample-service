package com.example.client.config;

import feign.Logger;
import feign.Request;
import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.ResponseEntityDecoder;
import org.springframework.cloud.netflix.feign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Configuration
public class FeignConfig {

    @Value("${feign.timeout.read}")
    private int readTimeout;

    @Value("${feign.timeout.connect}")
    private int connectTimeout;

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeout, readTimeout);
    }

    @Bean
    public Decoder responseDecoder() {
        return new ResponseEntityDecoder(new SpringDecoder(this.messageConverters));
    }

//    @Bean
//    public ErrorDecoder errorDecoder() {
//        return new FeignErrorDecoder();
//    }

    @Bean
    @Scope("prototype")
    public HttpHeaders getJsonHttpHeaders() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        return requestHeaders;
    }
}
