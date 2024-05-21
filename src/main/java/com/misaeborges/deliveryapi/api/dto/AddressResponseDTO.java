package com.misaeborges.deliveryapi.api.dto;

import lombok.Data;

@Data
public class AddressResponseDTO {

    private String cep;
    private String street;
    private String number;
    private String additionalAddressDetails;
    private String neighborhood;
    private CitySummaryResponseDTO city;
}
