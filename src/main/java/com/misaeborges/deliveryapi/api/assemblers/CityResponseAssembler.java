package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.CityResponseDTO;
import com.misaeborges.deliveryapi.domain.models.City;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CityResponseDTO toModell(City city) {
        return modelMapper.map(city, CityResponseDTO.class);
    }

    public List<CityResponseDTO> toCollectionModell(List<City> cities) {
        return cities.stream().map(this::toModell).collect(Collectors.toList());
    }

}
