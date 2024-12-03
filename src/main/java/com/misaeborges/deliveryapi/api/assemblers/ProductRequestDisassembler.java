package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.request.ProductRequestDTO;
import com.misaeborges.deliveryapi.api.dto.response.ProductResponseDTO;
import com.misaeborges.deliveryapi.domain.models.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Product toDomainObject(ProductRequestDTO productRequestDTO) {
        return modelMapper.map(productRequestDTO, Product.class);
    }

    public void copyToDomainObject(ProductRequestDTO productRequestDTO, Product product) {
        modelMapper.map(productRequestDTO, product);
    }
}
