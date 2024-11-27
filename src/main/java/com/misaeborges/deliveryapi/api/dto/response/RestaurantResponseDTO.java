package com.misaeborges.deliveryapi.api.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestaurantResponseDTO {

    private Long id;
    private String name;
    private BigDecimal deliveryFees;
    private CuisineResponseDTO cuisine;
    private AddressResponseDTO address;
}
