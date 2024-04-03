package com.misaeborges.deliveryapi.domain.services;

import com.misaeborges.deliveryapi.domain.dto.CuisineResquestDTO;
import com.misaeborges.deliveryapi.domain.exception.CuisineNotFoundException;
import com.misaeborges.deliveryapi.domain.model.Cuisine;
import com.misaeborges.deliveryapi.domain.repositories.ICuisineRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuisineService {

    @Autowired
    private ICuisineRespository cuisineRespository;

    public Cuisine save(CuisineResquestDTO cuisineDate) {
        Cuisine cuisine = new Cuisine(cuisineDate);
        return cuisineRespository.save(cuisine);
    }

    public Cuisine searchEngine(Long id) {
        return cuisineRespository.findById(id).orElseThrow(() -> new CuisineNotFoundException(id));
    }

}
