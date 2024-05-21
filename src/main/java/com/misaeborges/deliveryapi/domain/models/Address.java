package com.misaeborges.deliveryapi.domain.models;

import jakarta.persistence.*;
import lombok.Data;

@Embeddable
@Data
public class Address {

    @Column(name = "address_cep")
    private String cep;

    @Column(name = "address_street")
    private String street;

    @Column(name = "address_number")
    private String number;

    @Column(name = "additional_address_details")
    private String additionalAddressDetails;

    @Column(name = "address_neighborhood")
    private String neighborhood;

    @ManyToOne
    @JoinColumn(name = "address_city_id", nullable = false)
    private City city;

}
