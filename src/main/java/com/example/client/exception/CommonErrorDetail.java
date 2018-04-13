package com.example.client.exception;

import lombok.Builder;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

@Getter
@Builder
public class CommonErrorDetail implements Serializable {
    private static final long serialVersionUID = -6313867256850363149L;

    @JsonProperty("status")
    private int status;

    @JsonProperty("title")
    private String title;

    @JsonProperty("detail")
    private String detail;

    @JsonProperty("timestamp")
    private long timestamp;

    @JsonProperty("exception")
    private String exception;

    @JsonProperty("method")
    private String method;

    @JsonProperty("requestedPath")
    private String requestedPath;

}