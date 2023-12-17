package com.jaminel.minilibrary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class MiniLibraryExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {MiniLibraryNotFoundException.class})
    public ResponseEntity<Object>handlerObject(MiniLibraryNotFoundException notfoundException){

       Exceptions exceptionHandler = new Exceptions(notfoundException.getMessage(),notfoundException.getCause(), HttpStatus.NOT_FOUND);

    return new ResponseEntity<>(exceptionHandler,HttpStatus.NOT_FOUND);
    }
}
