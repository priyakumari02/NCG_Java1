package com.adobe.orderapp.api;

import com.adobe.orderapp.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, Object> messageBody = new LinkedHashMap<>();
        messageBody.put("timestamp", LocalDate.now());
        messageBody.put("message", ex.getMessage());
        return new ResponseEntity<Object>(messageBody, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, Object> messageBody = new LinkedHashMap<>();
        messageBody.put("timestamp", LocalDate.now());
        List<String> errors =
                ex.getBindingResult().getFieldErrors().stream().map(exception -> exception.getDefaultMessage()).collect(Collectors.toList());
        messageBody.put("errors", errors);
        return new ResponseEntity<Object>(messageBody, HttpStatus.BAD_REQUEST);
    }
}
