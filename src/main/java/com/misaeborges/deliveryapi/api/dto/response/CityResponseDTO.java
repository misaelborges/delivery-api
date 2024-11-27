package com.misaeborges.deliveryapi.api.dto.response;

import lombok.Data;

@Data
public class CityResponseDTO {

    private Long id;
    private String name;
    private StateResponseDTO state;
}
