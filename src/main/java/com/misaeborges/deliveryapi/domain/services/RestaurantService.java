package com.misaeborges.deliveryapi.domain.services;

import com.misaeborges.deliveryapi.api.dto.RestaurantRequestDTO;
import com.misaeborges.deliveryapi.domain.exception.RestaurantNotFoundException;
import com.misaeborges.deliveryapi.domain.models.Cuisine;
import com.misaeborges.deliveryapi.domain.models.Restaurant;
import com.misaeborges.deliveryapi.domain.repositories.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RestaurantService {

    @Autowired
    private IRestaurantRepository restaurantRepository;

    @Autowired
    private CuisineService cuisineService;

    @Transactional
    public Restaurant save(RestaurantRequestDTO data) {
        Cuisine cuisine = cuisineService.searchEngine(data.cuisine().getId());

        Restaurant restaurant = new Restaurant(data);

        restaurant.setCuisine(cuisine);

        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public void delete(Long id) {
        try {
            restaurantRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RestaurantNotFoundException(id);
        }
    }

    public Restaurant searchEngine(Long id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new RestaurantNotFoundException(id));
    }
}
