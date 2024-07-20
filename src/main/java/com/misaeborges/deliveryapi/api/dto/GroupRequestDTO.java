package com.misaeborges.deliveryapi.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GroupRequestDTO {

    @NotBlank
    private String name;
}
