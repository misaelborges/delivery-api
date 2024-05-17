package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.RestaurantResponseDTO;
import com.misaeborges.deliveryapi.domain.models.Restaurant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public RestaurantResponseDTO toModel(Restaurant restaurant) {
        return modelMapper.map(restaurant, RestaurantResponseDTO.class);
    }

    public List<RestaurantResponseDTO> toCollectionModel(List<Restaurant> restaurants) {
        return restaurants.stream().map(this::toModel).collect(Collectors.toList());
    }

}
