package com.timposulabs.demo_mvc_dto_example.config;

import com.timposulabs.demo_mvc_dto_example.exception.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlerPersonNotFound(PersonNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Person Not Found");
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
