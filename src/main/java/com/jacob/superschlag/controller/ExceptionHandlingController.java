package com.jacob.superschlag.controller;

import com.jacob.superschlag.exception.InvalidOwnedItemListException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity notFound() {
        return new ResponseEntity("Entity not found!", HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(InvalidOwnedItemListException.class)
    protected ResponseEntity invalid() {
        return new ResponseEntity("Invalid owned item list!", HttpStatus.NOT_ACCEPTABLE);
    }
}