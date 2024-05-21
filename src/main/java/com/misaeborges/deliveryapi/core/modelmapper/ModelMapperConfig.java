package com.misaeborges.deliveryapi.core.modelmapper;

import com.misaeborges.deliveryapi.api.dto.AddressResponseDTO;
import com.misaeborges.deliveryapi.domain.models.Address;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        var addressToAddressModelTypeMap =
                modelMapper.createTypeMap(Address.class, AddressResponseDTO.class);

        addressToAddressModelTypeMap.<String>addMapping(
                address -> address.getCity().getState().getName(),
                (addressResponseDTO, valor) -> addressResponseDTO.getCity().setState(valor));

        return modelMapper;
    }
}
