package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.response.UserResponseDTO;
import com.misaeborges.deliveryapi.domain.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public UserResponseDTO toModel(User user) {
        return modelMapper.map(user, UserResponseDTO.class);
    }

    public List<UserResponseDTO> toCollectionModel(List<User> user) {
        return user.stream().map(this::toModel).collect(Collectors.toList());
    }
}
