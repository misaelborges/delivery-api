package com.misaeborges.deliveryapi.api.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestaurantRequestDTO {

    @NotBlank
    private String name;

    @NotNull
    @PositiveOrZero
    private BigDecimal deliveryFees;

    @Valid
    @NotNull
    private CuisineIdDTO cuisine;

    @Valid
    @NotNull
    private AddressRequestDTO address;
}
