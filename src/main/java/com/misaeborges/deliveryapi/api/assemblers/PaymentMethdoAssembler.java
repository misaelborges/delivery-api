package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.response.PaymentMethodResponseDTO;
import com.misaeborges.deliveryapi.domain.models.PaymentMethod;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentMethdoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public PaymentMethodResponseDTO toModel(PaymentMethod paymentMethod) {
        return modelMapper.map(paymentMethod, PaymentMethodResponseDTO.class);
    }

    public List<PaymentMethodResponseDTO> toCollectionModel(List<PaymentMethod> paymentMethods) {
        return paymentMethods.stream().map(this::toModel).collect(Collectors.toList());
    }
}
