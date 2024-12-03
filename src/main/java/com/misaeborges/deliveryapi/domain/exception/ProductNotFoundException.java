package com.misaeborges.deliveryapi.domain.exception;

public class ProductNotFoundException extends EntityNotFoundException{

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(Long id) {
        this(String.format("There is no product registration with code %d", id));
    }

    public ProductNotFoundException(Long restauranteId, Long produtoId) {
        super(String.format("There is no product registration with code %d for the restaurant with code %d", restauranteId, produtoId));
    }
}
