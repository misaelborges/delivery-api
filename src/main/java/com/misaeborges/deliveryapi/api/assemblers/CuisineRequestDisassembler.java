package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.request.CuisineResquestDTO;
import com.misaeborges.deliveryapi.domain.models.Cuisine;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CuisineRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cuisine toDomainObject(CuisineResquestDTO cuisineResquestDTO) {
        return modelMapper.map(cuisineResquestDTO, Cuisine.class);
    }

    public void copyToDomainObject(CuisineResquestDTO cuisineResquestDTO, Cuisine cuisine) {
        modelMapper.map(cuisineResquestDTO, cuisine);
    }
}
