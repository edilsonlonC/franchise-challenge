package com.challenge.franchise.infrastructure.api.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.stream.Collectors;

@ControllerAdvice
public class ValidationExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValid(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(
                ex.getAllErrors()
                        .stream().map(e -> e.getDefaultMessage())
                        .collect(Collectors.toList())
                , HttpStatus.BAD_REQUEST);
    }
}
