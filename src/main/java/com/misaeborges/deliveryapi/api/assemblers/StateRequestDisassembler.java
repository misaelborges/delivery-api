package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.StateRequestDTO;
import com.misaeborges.deliveryapi.domain.models.State;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StateRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public State toDomainObject(StateRequestDTO stateRequestDTO) {
        return modelMapper.map(stateRequestDTO, State.class);
    }

    public void copyToDomainObject(StateRequestDTO stateRequestDTO, State state) {
        modelMapper.map(stateRequestDTO, state);
    }
}
