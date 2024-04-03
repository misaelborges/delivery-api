package com.misaeborges.deliveryapi.domain.exception;

public class EntityInUseException extends RuntimeException{

    public EntityInUseException(String message) {
        super(message);
    }

    public EntityInUseException(Long id) {
        this(String.format("Entity %d cannot be deleted as it is in use", id));
    }

}
