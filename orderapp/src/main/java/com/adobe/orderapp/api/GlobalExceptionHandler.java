package com.adobe.orderapp.api;

import com.adobe.orderapp.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, Object> messageBody = new LinkedHashMap<>();
        messageBody.put("timestamp", LocalDate.now());
        messageBody.put("message", ex.getMessage());
        return new ResponseEntity<Object>(messageBody, HttpStatus.NOT_FOUND);
    }
}
