package com.misaeborges.deliveryapi.domain.exception;

public class PaymentMethodNotFoundException extends EntityNotFoundException{

    public PaymentMethodNotFoundException(String message) {
        super(message);
    }

    public PaymentMethodNotFoundException(Long id) {
        this(String.format("There is no payment method registration with code %d", id));
    }
}
