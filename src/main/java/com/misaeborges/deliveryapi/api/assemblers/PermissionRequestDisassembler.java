package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.PermissionRequestDTO;
import com.misaeborges.deliveryapi.domain.models.Permission;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PermissionRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Permission toModel(PermissionRequestDTO requestDTO) {
        return modelMapper.map(requestDTO, Permission.class);
    }

    public void copyToDomainObject(PermissionRequestDTO requestDTO, Permission permission) {
        modelMapper.map(requestDTO, permission);
    }
}
