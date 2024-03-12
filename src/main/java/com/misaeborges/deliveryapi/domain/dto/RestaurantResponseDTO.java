package com.misaeborges.deliveryapi.domain.dto;

import com.misaeborges.deliveryapi.domain.model.Restaurant;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RestaurantResponseDTO(Long id, String name, BigDecimal deliveryFees, LocalDateTime registrationDate,
                                    LocalDateTime updateDate) {

    public RestaurantResponseDTO(Restaurant restaurant) {
        this(restaurant.getId(), restaurant.getName(), restaurant.getDeliveryFees(),
                restaurant.getRegistrationDate(), restaurant.getUpdateDate());
    }
}
