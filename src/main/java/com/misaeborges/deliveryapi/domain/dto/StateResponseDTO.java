package com.misaeborges.deliveryapi.domain.dto;

import com.misaeborges.deliveryapi.domain.models.State;

public record StateResponseDTO(Long id, String name) {

    public StateResponseDTO(State state) {
        this(state.getId(), state.getName());
    }
}
