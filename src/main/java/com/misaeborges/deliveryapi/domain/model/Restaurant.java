package com.misaeborges.deliveryapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @Column(nullable = false)
    private BigDecimal deliveryFees;

    @JsonIgnore
    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime registrationDate;

    @JsonIgnore
    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "cuisine_id", nullable = false)
    private Cuisine cuisine;

    public Restaurant(@NotNull RestaurantRequestDTO restaurantDTO) {
        this.name = restaurantDTO.name();
        this.deliveryFees = restaurantDTO.deliveryFees();
        this.registrationDate = restaurantDTO.registrationDate();
        this.updateDate = restaurantDTO.updateDate();
        this.cuisine = restaurantDTO.cuisine();
    }

}
