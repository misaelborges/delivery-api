package com.misaeborges.deliveryapi.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RestaurantRequestDTO(String name, BigDecimal deliveryFees, LocalDateTime registrationDate,
                                   LocalDateTime updateDate) {
}
