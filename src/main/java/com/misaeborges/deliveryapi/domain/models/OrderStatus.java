package com.misaeborges.deliveryapi.domain.models;

import java.util.Arrays;
import java.util.List;

public enum OrderStatus {

    CREATED("Created"),
    CONFIRMED("Confirmed", CREATED),
    DELIVERED("Delivered", CONFIRMED),
    CANCELED("Canceled", CREATED);

    private final List<OrderStatus> previousStatus;

    OrderStatus(String description, OrderStatus... orderStatus) {
        this.previousStatus = Arrays.asList(orderStatus);
    }

    public boolean cannotTransitionTo(OrderStatus orderStatus) {
        return !orderStatus.previousStatus.contains(this);
    }

}
