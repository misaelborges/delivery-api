package com.misaeborges.deliveryapi.domain.exception;

public class PermissionNotFoundException extends EntityNotFoundException{

    public PermissionNotFoundException(String message) {
        super(message);
    }

    public PermissionNotFoundException(Long id) {
        this(String.format("There is no permission registration with code %d", id));
    }
}
