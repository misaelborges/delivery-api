package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.request.UserRequestDTO;
import com.misaeborges.deliveryapi.domain.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public User toDomainObject(UserRequestDTO userRequestDTO) {
        return modelMapper.map(userRequestDTO, User.class);
    }

    public void copyToDomainObject(UserRequestDTO userRequestDTO, User user) {
        modelMapper.map(userRequestDTO, user);
    }

}
