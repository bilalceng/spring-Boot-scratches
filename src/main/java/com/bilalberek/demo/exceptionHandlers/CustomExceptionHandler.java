package com.bilalberek.demo.exceptionHandlers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<HashMap<String, String>> handleValidationExceptions(MethodArgumentNotValidException exp){

        HashMap<String, String> errors = new HashMap<>();
        exp.getBindingResult().getAllErrors().forEach((error) ->{
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    errors.put(fieldName,errorMessage);
                }
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}