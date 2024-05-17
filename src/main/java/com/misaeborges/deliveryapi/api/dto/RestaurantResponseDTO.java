package com.misaeborges.deliveryapi.api.dto;

import lombok.Data;

@Data
public class RestaurantResponseDTO {

    private Long id;
    private String name;
    private CuisineResponseDTO cuisine;
}
