package com.misaeborges.deliveryapi.domain.services;

import com.misaeborges.deliveryapi.domain.dto.RestaurantRequestDTO;
import com.misaeborges.deliveryapi.domain.exception.RestaurantNotFoundException;
import com.misaeborges.deliveryapi.domain.model.Restaurant;
import com.misaeborges.deliveryapi.domain.repositories.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private IRestaurantRepository restaurantRepository;


    public Restaurant save(RestaurantRequestDTO data) {
        Restaurant restaurant = new Restaurant(data);
        return restaurantRepository.save(restaurant);
    }

    public void delete(Long id) {
        try {
            restaurantRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RestaurantNotFoundException(id);
        }
    }

    public Restaurant searchEngine( Long id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new RestaurantNotFoundException(id));
    }
}
