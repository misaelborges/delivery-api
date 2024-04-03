package com.misaeborges.deliveryapi.domain.exception;

public class CuisineNotFoundException extends EntityNotFoundException{

    public CuisineNotFoundException(String message) {
        super(message);
    }

    public CuisineNotFoundException(Long id) {
        this(String.format("There is no cuisine registration with code %d", id));
    }
}
