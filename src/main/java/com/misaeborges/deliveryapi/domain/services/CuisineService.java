package com.misaeborges.deliveryapi.domain.services;

import com.misaeborges.deliveryapi.domain.dto.CuisineResquestDTO;
import com.misaeborges.deliveryapi.domain.exception.CuisineNotFoundException;
import com.misaeborges.deliveryapi.domain.exception.EntityInUseException;
import com.misaeborges.deliveryapi.domain.model.Cuisine;
import com.misaeborges.deliveryapi.domain.repositories.ICuisineRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CuisineService {

    @Autowired
    private ICuisineRespository cuisineRespository;

    public Cuisine save(CuisineResquestDTO cuisineDate) {
        Cuisine cuisine = new Cuisine(cuisineDate);
        return cuisineRespository.save(cuisine);
    }

    public void delete(Long id) {
        try {
            cuisineRespository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new CuisineNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(id);
        }
    }

    public Cuisine searchEngine(Long id) {
        return cuisineRespository.findById(id).orElseThrow(() -> new CuisineNotFoundException(id));
    }

}
