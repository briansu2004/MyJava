package com.springboot.compositekey.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//exception class in case the book not found in the db

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EntityNotFound extends Exception {

    private static final long serialVersionUID = 1L;

    public EntityNotFound() {
        super();
    }
}
