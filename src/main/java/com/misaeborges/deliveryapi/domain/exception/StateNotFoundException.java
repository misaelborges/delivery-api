package com.misaeborges.deliveryapi.domain.exception;

public class StateNotFoundException extends EntityNotFoundException{

    public StateNotFoundException(String message) {
        super(message);
    }

    public StateNotFoundException(Long id) {
        this(String.format("There is no state registration with code %d", id));
    }
}
