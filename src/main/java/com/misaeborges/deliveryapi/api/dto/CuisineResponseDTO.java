package com.misaeborges.deliveryapi.api.dto;

import com.misaeborges.deliveryapi.domain.models.Cuisine;

public record CuisineResponseDTO(Long id, String name) {

    public CuisineResponseDTO(Cuisine cuisine) {
        this(cuisine.getId(), cuisine.getName());
    }
}
