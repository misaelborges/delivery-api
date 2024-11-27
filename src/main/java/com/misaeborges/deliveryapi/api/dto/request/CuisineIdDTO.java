package com.misaeborges.deliveryapi.api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CuisineIdDTO {

    @NotNull
    private Long id;
}
