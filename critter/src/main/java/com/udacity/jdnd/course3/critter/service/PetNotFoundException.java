package com.udacity.jdnd.course3.critter.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Pet not found")
public class PetNotFoundException extends RuntimeException {

    public PetNotFoundException() {
    }

    public PetNotFoundException(String message) {
        super(message);
    }
}

