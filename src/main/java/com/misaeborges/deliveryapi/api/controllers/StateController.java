package com.misaeborges.deliveryapi.api.controllers;

import com.misaeborges.deliveryapi.domain.dto.StateResponseDTO;
import com.misaeborges.deliveryapi.domain.repositories.IStateRepository;
import com.misaeborges.deliveryapi.domain.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private IStateRepository stateRepository;

    private StateService stateService;

    @GetMapping
    public List<StateResponseDTO> getAll() {
        return stateRepository.findAll().stream().map(StateResponseDTO::new).toList();
    }
}
