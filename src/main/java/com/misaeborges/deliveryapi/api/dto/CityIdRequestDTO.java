package com.misaeborges.deliveryapi.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CityIdRequestDTO {

    @NotNull
    private Long id;
}
