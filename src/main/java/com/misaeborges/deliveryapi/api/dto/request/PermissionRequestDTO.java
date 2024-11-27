package com.misaeborges.deliveryapi.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PermissionRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String description;
}
