package com.misaeborges.deliveryapi.domain.models;

import com.misaeborges.deliveryapi.api.dto.CuisineResquestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cuisine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Cuisine(CuisineResquestDTO cuisineResquestDTO) {
        this.name = cuisineResquestDTO.name();
    }
}
