package com.misaeborges.deliveryapi.api.controllers;

import com.misaeborges.deliveryapi.api.assemblers.GroupPermissionAssembler;
import com.misaeborges.deliveryapi.api.assemblers.GroupRequestDisassembler;
import com.misaeborges.deliveryapi.api.assemblers.GroupResponseAssembler;
import com.misaeborges.deliveryapi.api.dto.GroupPermissionResponseDTO;
import com.misaeborges.deliveryapi.api.dto.GroupRequestDTO;
import com.misaeborges.deliveryapi.api.dto.GroupResponseDTO;
import com.misaeborges.deliveryapi.domain.models.Group;
import com.misaeborges.deliveryapi.domain.repositories.IGroupRepository;
import com.misaeborges.deliveryapi.domain.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private IGroupRepository groupRepository;

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupResponseAssembler groupResponseAssembler;

    @Autowired
    private GroupRequestDisassembler groupRequestDisassembler;

    @Autowired
    private GroupPermissionAssembler groupPermissionAssembler;

    @GetMapping
    public List<GroupResponseDTO> findAll() {
        return groupResponseAssembler.toCollectionModel(groupRepository.findAll());
    }

    @GetMapping("/{id}")
    public GroupResponseDTO findById(@PathVariable Long id) {
        return groupResponseAssembler.toModel(groupService.searchEngine(id));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public GroupResponseDTO save(@RequestBody Group group) {
        return groupResponseAssembler.toModel(groupService.save(group));
    }

    @PutMapping("/{id}")
    public GroupResponseDTO toUpdate(@RequestBody GroupRequestDTO requestDTO, @PathVariable Long id) {
        Group group = groupService.searchEngine(id);
        groupRequestDisassembler.copyToDomainObject(requestDTO, group);
        return groupResponseAssembler.toModel(groupService.save(group));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        groupService.delete(id);
    }

}
