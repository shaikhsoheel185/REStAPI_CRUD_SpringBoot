package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class exceptionHandler extends Exception {
    public exceptionHandler(String message) {
        super(message);
    }

}
