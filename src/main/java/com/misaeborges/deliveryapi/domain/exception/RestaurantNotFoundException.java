package com.misaeborges.deliveryapi.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RestaurantNotFoundException extends EntityNotFoundException{

    public RestaurantNotFoundException(String message) {
        super(message);
    }

    public RestaurantNotFoundException(Long id) {
        this(String.format("There is no restaurant registration with code %d", id));
    }

}
