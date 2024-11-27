package com.misaeborges.deliveryapi.api.assemblers;

import com.misaeborges.deliveryapi.api.dto.response.GroupResponseDTO;
import com.misaeborges.deliveryapi.domain.models.Group;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public GroupResponseDTO toModel(Group group) {
        return modelMapper.map(group, GroupResponseDTO.class);
    }

    public List<GroupResponseDTO> toCollectionModel(List<Group> groups) {
        return groups.stream().map(this::toModel).collect(Collectors.toList());
    }
}
