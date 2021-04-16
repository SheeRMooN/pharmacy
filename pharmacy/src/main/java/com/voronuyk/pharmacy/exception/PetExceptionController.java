package com.voronuyk.pharmacy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PetExceptionController {

    @ExceptionHandler(value = PetException.class)
    public ResponseEntity<Object> exception(PetException exception) {
        return new ResponseEntity<>("Pet not found" + exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}