package com.misaeborges.deliveryapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.misaeborges.deliveryapi.domain.model.Restaurant;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RestaurantResponseDTO(Long id, String name, @JsonIgnore BigDecimal deliveryFees, @JsonIgnore LocalDateTime registrationDate,
                                    @JsonIgnore LocalDateTime updateDate) {

    public RestaurantResponseDTO(Restaurant restaurant) {
        this(restaurant.getId(), restaurant.getName(), restaurant.getDeliveryFees(),
                restaurant.getRegistrationDate(), restaurant.getUpdateDate());
    }
}
