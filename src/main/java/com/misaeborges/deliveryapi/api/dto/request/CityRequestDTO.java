package com.misaeborges.deliveryapi.api.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CityRequestDTO {

    @NotBlank
    private String name;

    @Valid
    @NotNull
    private StateIdDTO state;
}
