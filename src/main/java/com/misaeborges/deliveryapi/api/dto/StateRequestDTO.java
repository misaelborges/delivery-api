package com.misaeborges.deliveryapi.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StateRequestDTO {

    @NotBlank
    String name;
}
