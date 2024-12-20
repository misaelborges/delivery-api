package com.misaeborges.deliveryapi.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends BusinessException{

    public EntityNotFoundException(String message) {
        super(message);
    }
}
