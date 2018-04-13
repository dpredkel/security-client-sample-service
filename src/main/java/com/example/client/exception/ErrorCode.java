package com.example.client.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    ERROR_VALIDATION(400_0);

    private int value;

}
