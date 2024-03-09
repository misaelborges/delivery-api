package com.misaeborges.deliveryapi.domain.repositories;

import com.misaeborges.deliveryapi.domain.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Long> {
}
