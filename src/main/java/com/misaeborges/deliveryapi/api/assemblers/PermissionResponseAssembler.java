package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.response.PermissionResponseDTO;
import com.misaeborges.deliveryapi.domain.models.Permission;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PermissionResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public PermissionResponseDTO toModel(Permission permission) {
        return modelMapper.map(permission, PermissionResponseDTO.class);
    }

    public List<PermissionResponseDTO> toCollectionModel(List<Permission> permissions) {
        return permissions.stream().map(this::toModel).collect(Collectors.toList());
    }
}
