package com.misaeborges.deliveryapi.domain.exception;

public class CityNotFoundException extends EntityNotFoundException{

    public CityNotFoundException(String message) {
        super(message);
    }

    public CityNotFoundException(Long id) {
        this(String.format("There is no city registration with code %d", id));
    }
}
