package com.misaeborges.deliveryapi.domain.repositories;

import com.misaeborges.deliveryapi.domain.model.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICuisineRespository extends JpaRepository<Cuisine, Long> {
}
