package com.jobapp.JobApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NoSuchElementException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimeStamp(LocalDateTime.now());
        errorResponse.setDetails(Collections.singletonList("The requested resource was not found"));
        errorResponse.setError("Not Found");
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setCode("ERR_NOT_FOUND ");
        errorResponse.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleValidationError(HttpMessageNotReadableException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimeStamp(LocalDateTime.now());
        errorResponse.setDetails(Collections.singletonList("Invalid JSON format or type mismatch"));
        errorResponse.setError("Bad Request");
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setCode("ERR_INVALID_JSON");
        errorResponse.setMessage(ex.getMostSpecificCause().getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
