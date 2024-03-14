package com.misaeborges.deliveryapi.domain.dto;

import com.misaeborges.deliveryapi.domain.model.Cuisine;

public record CuisineResponseDTO(Long id, String name) {

    public CuisineResponseDTO(Cuisine cuisine) {
        this(cuisine.getId(), cuisine.getName());
    }
}
