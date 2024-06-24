package com.example.amazonagency.handler;

import com.example.amazonagency.exception.InvalidSortOrOrderException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidSortOrOrderException.class)
    public ResponseEntity<String> handleInvalidSortOrOrderException(InvalidSortOrOrderException ex) {
        log.error("Invalid sort field or order: {}", ex.getMessage());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
