package com.misaeborges.deliveryapi.domain.model;

import com.misaeborges.deliveryapi.domain.dto.RestaurantRequestDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal deliveryFees;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime registrationDate;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime updateDate;

    public Restaurant(RestaurantRequestDTO restaurantDTO) {
        this.name = restaurantDTO.name();
        this.deliveryFees = restaurantDTO.deliveryFees();
        this.registrationDate = restaurantDTO.registrationDate();
        this.updateDate = restaurantDTO.updateDate();
    }

}
