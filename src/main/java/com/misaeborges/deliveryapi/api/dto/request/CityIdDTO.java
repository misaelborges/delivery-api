package com.misaeborges.deliveryapi.api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CityIdDTO {

    @NotNull
    private Long id;
}
