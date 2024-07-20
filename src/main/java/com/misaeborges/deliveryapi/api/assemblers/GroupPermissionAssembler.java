package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.GroupPermissionResponseDTO;
import com.misaeborges.deliveryapi.domain.models.Group;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupPermissionAssembler {

    @Autowired
    ModelMapper modelMapper;

    public GroupPermissionResponseDTO toModel(Group group) {
        return modelMapper.map(group, GroupPermissionResponseDTO.class);
    }

    public List<GroupPermissionResponseDTO> toCollectionModel(List<Group> groups) {
        return groups.stream().map(this::toModel).collect(Collectors.toList());
    }
}
