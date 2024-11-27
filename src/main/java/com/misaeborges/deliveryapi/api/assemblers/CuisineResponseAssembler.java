package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.response.CuisineResponseDTO;
import com.misaeborges.deliveryapi.domain.models.Cuisine;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CuisineResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CuisineResponseDTO toModel(Cuisine cuisine) {
        return modelMapper.map(cuisine, CuisineResponseDTO.class);
    }

    public List<CuisineResponseDTO> toCollectionModel(List<Cuisine> cuisines) {
        return cuisines.stream().map(this::toModel).collect(Collectors.toList());
    }
}
