package com.example.fooddeliveryservice.exception.handler;

import com.example.fooddeliveryservice.dto.ResponseDto;
import com.example.fooddeliveryservice.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> customExceptionHandler(CustomException customException) {
        ResponseDto response = new ResponseDto();
        response.setStatusCode(customException.getErrorCode());
        response.setMessage(customException.getMessage());
        response.setError(true);
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exceptionHandler(Exception exception) {
        ResponseDto response = new ResponseDto();
        response.setStatusCode(exception.hashCode());
        response.setMessage(exception.getMessage());
        response.setError(true);
        return ResponseEntity.ok(response);
    }

}
