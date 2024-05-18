package com.misaeborges.deliveryapi.api.dto;

import com.misaeborges.deliveryapi.domain.models.State;
import lombok.Data;

@Data
public class CityResponseDTO {

    private Long id;
    private String name;
    private State state;
}
