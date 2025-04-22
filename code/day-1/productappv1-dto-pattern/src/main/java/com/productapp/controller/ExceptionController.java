package com.productapp.controller;

import com.productapp.dto.ErrorDetails;
import com.productapp.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionController {

    //i need to handle ProductNotFoundException
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleProductNotFoundException(ProductNotFoundException ex){
        ErrorDetails errorDetails =ErrorDetails.builder().name("ravi")
                .localDateTime(LocalDateTime.now()).message(ex.getMessage()).statusCode("404").build();
        return ResponseEntity.status(404).body(errorDetails);
    }
    //i need to handle ProductNotFoundException
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handle500(Exception ex){
        ErrorDetails errorDetails =ErrorDetails.builder().name("ravi")
                .localDateTime(LocalDateTime.now()).message("try after some time").statusCode("500").build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }

    //MethodArgumentNotValidException
        @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handle400(MethodArgumentNotValidException ex){

        String errorMessage = ex.getBindingResult()
                .getAllErrors().stream()
                .map(e -> e.getDefaultMessage()).collect(Collectors.joining(", "));


        ErrorDetails errorDetails =ErrorDetails.builder().name("ravi")
                .localDateTime(LocalDateTime.now()).message(errorMessage).statusCode("400").build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
}
