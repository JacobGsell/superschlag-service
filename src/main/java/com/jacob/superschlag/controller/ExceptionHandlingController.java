package com.jacob.superschlag.controller;

import com.jacob.superschlag.exception.InvalidOwnedItemListException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionHandlingController {
    // Exception handling methods

    // Convert a predefined exception to an HTTP Status code
    @ResponseStatus(value= HttpStatus.NOT_FOUND,
            reason="Entity not found")  // 404
    @ExceptionHandler(EntityNotFoundException.class)
    public void notFound() {
    }

    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE,
    reason = "Not acceptable")
    @ExceptionHandler(InvalidOwnedItemListException.class)
    public void invalid() {
    }
}