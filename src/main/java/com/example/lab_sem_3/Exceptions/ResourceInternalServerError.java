package com.example.lab_sem_3.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ResourceInternalServerError extends RuntimeException {
    public ResourceInternalServerError(String message) {
        super(message);
    }
}
