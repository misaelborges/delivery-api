package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.RestaurantRequestDTO;
import com.misaeborges.deliveryapi.domain.models.Cuisine;
import com.misaeborges.deliveryapi.domain.models.Restaurant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Restaurant toDomainObject(RestaurantRequestDTO requestDTO) {
        return modelMapper.map(requestDTO, Restaurant.class);
    }

    public void copyToDomainObject(RestaurantRequestDTO requestDTO, Restaurant restaurant) {
        restaurant.setCuisine(new Cuisine());
        modelMapper.map(requestDTO, restaurant);
    }
}
