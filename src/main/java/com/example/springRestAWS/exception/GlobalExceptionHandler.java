package com.example.springRestAWS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    //ExceptionHandler RestrictedInfoException Custom
    @ExceptionHandler(RestrictedInfoException.class)
    public ResponseEntity restrictedInfoError(RestrictedInfoException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    //Exception Handler NoSuchElementException
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity noSuchElementError(RestrictedInfoException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
    }
}
