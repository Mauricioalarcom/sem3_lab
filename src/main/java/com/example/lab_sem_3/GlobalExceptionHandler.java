package com.example.lab_sem_3;

import com.example.lab_sem_3.Exceptions.Bad_GatewayException;
import com.example.lab_sem_3.Exceptions.ResourceConflictException;
import com.example.lab_sem_3.Exceptions.ResourceInternalServerError;
import com.example.lab_sem_3.Exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(ResourceConflictException.class)
    public ResponseEntity<String> handleResourceConflictException(ResourceConflictException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(ResourceInternalServerError.class)
    public ResponseEntity<String> handleResourceInternalServerError(ResourceInternalServerError e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler(Bad_GatewayException.class)
    public ResponseEntity<String> handleBadGatewayException(Bad_GatewayException e) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
    }

}


