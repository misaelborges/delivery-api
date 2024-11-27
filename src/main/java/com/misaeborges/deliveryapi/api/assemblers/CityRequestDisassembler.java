package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.request.CityRequestDTO;
import com.misaeborges.deliveryapi.domain.models.City;
import com.misaeborges.deliveryapi.domain.models.State;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public City toDomainObject(CityRequestDTO cityRequestDTO) {
        return modelMapper.map(cityRequestDTO, City.class);
    }

    public void copyToDomainObject(CityRequestDTO cityRequestDTO, City city) {
        // para evitar org.hibernate.HibernateException: identifier of an instance of
        // deliveryapi.domain.models.State was altered from 2 to 1
        city.setState(new State()) ;

        modelMapper.map(cityRequestDTO, city);
    }
}
