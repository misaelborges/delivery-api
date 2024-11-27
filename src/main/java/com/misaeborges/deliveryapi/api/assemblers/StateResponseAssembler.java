package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.response.StateResponseDTO;
import com.misaeborges.deliveryapi.domain.models.State;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StateResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;


    public StateResponseDTO toModel(State state) {
        return modelMapper.map(state, StateResponseDTO.class);
    }

    public List<StateResponseDTO> toCollectionModel(List<State> states) {
        return states.stream().map(this::toModel).collect(Collectors.toList());
    }
}
