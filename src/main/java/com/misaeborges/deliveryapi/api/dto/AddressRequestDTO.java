package com.misaeborges.deliveryapi.api.dto;

import com.misaeborges.deliveryapi.domain.models.City;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private CityIdRequestDTO city;

}
