package com.misaeborges.deliveryapi.api.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddressRequestDTO {

    @NotBlank
    private String cep;

    @NotBlank
    private String street;

    @NotBlank
    private String number;

    private String additionalAddressDetails;

    @NotBlank
    private String neighborhood;

    @Valid
    @NotNull
    private CityIdDTO city;

}
