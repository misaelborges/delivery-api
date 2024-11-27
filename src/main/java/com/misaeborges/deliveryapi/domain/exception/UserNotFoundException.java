package com.misaeborges.deliveryapi.domain.exception;

public class UserNotFoundException extends EntityNotFoundException{

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Long id) {
        this(String.format("There is no user registration with code %d", id));
    }
}
