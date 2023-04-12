package com.newsline.newsline.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleAllExceptionMethod(Exception ex) {
        StringBuilder sb = new StringBuilder();
        List<FieldError> fieldErrors = ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors();
        sb.append("{\n");
        for(FieldError fieldError: fieldErrors){
            sb.append("\"");
            sb.append(fieldError.getField());
            sb.append("\"");
            sb.append(":");
            sb.append("\"");
            sb.append(fieldError.getDefaultMessage());
            sb.append("\"");
            sb.append("\n");
        }
        sb.append("}\n");
        return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
    }
}
