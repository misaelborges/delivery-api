package com.misaeborges.deliveryapi.api.controllers;

import com.misaeborges.deliveryapi.api.assemblers.StateRequestDisassembler;
import com.misaeborges.deliveryapi.api.assemblers.StateResponseAssembler;
import com.misaeborges.deliveryapi.api.dto.StateRequestDTO;
import com.misaeborges.deliveryapi.api.dto.StateResponseDTO;
import com.misaeborges.deliveryapi.domain.models.State;
import com.misaeborges.deliveryapi.domain.repositories.IStateRepository;
import com.misaeborges.deliveryapi.domain.services.StateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private IStateRepository stateRepository;

    @Autowired
    private StateService stateService;

    @Autowired
    private StateResponseAssembler responseAssembler;

    @Autowired
    private StateRequestDisassembler stateRequestDisassembler;

    @GetMapping
    public List<StateResponseDTO> getAll() {
        return responseAssembler.toCollectionModel(stateRepository.findAll());
    }

    @GetMapping("/{id}")
    public StateResponseDTO findById(@PathVariable Long id) {
        return responseAssembler.toModel(stateService.searchEngine(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StateResponseDTO save(@RequestBody @Valid StateRequestDTO stateRequestDTO) {
        State state = stateRequestDisassembler.toDomainObject(stateRequestDTO);

        return responseAssembler.toModel(stateService.save(state));
    }

    @PutMapping("/{id}")
    public StateResponseDTO update(@PathVariable Long id, @RequestBody @Valid StateRequestDTO stateRequestDTO) {
        State state = stateService.searchEngine(id);

        stateRequestDisassembler.copyToDomainObject(stateRequestDTO, state);

        return responseAssembler.toModel(stateService.save(state));
    }

}
