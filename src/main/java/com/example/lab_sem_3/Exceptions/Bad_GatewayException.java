package com.example.lab_sem_3.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
public class Bad_GatewayException extends RuntimeException {
    public Bad_GatewayException(String message) {
        super(message);
    }
}
