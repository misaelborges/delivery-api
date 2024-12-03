package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.response.ProductResponseDTO;
import com.misaeborges.deliveryapi.domain.models.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ProductResponseDTO toModell(Product product) {
        return modelMapper.map(product, ProductResponseDTO.class);
    }

    public List<ProductResponseDTO> toCollectionModell(List<Product> products) {
        return products.stream().map(this::toModell).collect(Collectors.toList());
    }

}
