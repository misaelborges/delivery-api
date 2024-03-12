package com.misaeborges.deliveryapi.domain.model;

import com.misaeborges.deliveryapi.domain.dto.RestaurantRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public Restaurant(@NotNull RestaurantRequestDTO restaurantDTO) {
        this.name = restaurantDTO.name();
        this.deliveryFees = restaurantDTO.deliveryFees();
        this.registrationDate = restaurantDTO.registrationDate();
        this.updateDate = restaurantDTO.updateDate();
    }

}
