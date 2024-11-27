package com.misaeborges.deliveryapi.api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StateIdDTO {

    @NotNull
    private Long id;
}
