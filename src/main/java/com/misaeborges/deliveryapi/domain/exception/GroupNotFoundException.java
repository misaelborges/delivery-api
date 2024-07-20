package com.misaeborges.deliveryapi.domain.exception;

public class GroupNotFoundException extends EntityNotFoundException{

    public GroupNotFoundException(String message) {
        super(message);
    }

    public GroupNotFoundException(Long id) {
        this(String.format("There is no group registration with code %d", id));
    }
}
