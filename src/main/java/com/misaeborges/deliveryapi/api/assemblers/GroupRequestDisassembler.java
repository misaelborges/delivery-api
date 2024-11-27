package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.request.GroupRequestDTO;
import com.misaeborges.deliveryapi.domain.models.Group;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Group toDomainObject(GroupRequestDTO groupRequestDTO) {
        return modelMapper.map(groupRequestDTO, Group.class);
    }

    public void copyToDomainObject(GroupRequestDTO groupRequestDTO, Group group) {
        modelMapper.map(groupRequestDTO, group);
    }
}
