package com.misaeborges.deliveryapi.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CuisineResquestDTO {

    @NotBlank
    private String name;
}
