package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.request.RestaurantRequestDTO;
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
        // para evitar org.hibernate.HibernateException: identifier of an instance of
        // deliveryapi.domain.models.Cuisine was altered from 2 to 1
        restaurant.setCuisine(new Cuisine());
        modelMapper.map(requestDTO, restaurant);
    }
}
