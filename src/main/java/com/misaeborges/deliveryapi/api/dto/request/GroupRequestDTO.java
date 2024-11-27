package com.misaeborges.deliveryapi.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GroupRequestDTO {

    @NotBlank
    private String name;
}
