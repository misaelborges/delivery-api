package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.request.PaymentMethodRequestDTO;
import com.misaeborges.deliveryapi.api.dto.response.PaymentMethodResponseDTO;
import com.misaeborges.deliveryapi.domain.models.PaymentMethod;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentMethdoDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public PaymentMethod toModel(PaymentMethodRequestDTO paymentMethod) {
        return modelMapper.map(paymentMethod, PaymentMethod.class);
    }

    public void toCollectionModel(PaymentMethodRequestDTO paymentMethodRequestDTO, PaymentMethod paymentMethod) {
        modelMapper.map(paymentMethodRequestDTO, paymentMethod);
    }
}