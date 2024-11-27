package com.misaeborges.deliveryapi.api.controllers;

import com.misaeborges.deliveryapi.api.assemblers.UserRequestDisassembler;
import com.misaeborges.deliveryapi.api.assemblers.UserResponseAssembler;
import com.misaeborges.deliveryapi.api.dto.request.UserRequestDTO;
import com.misaeborges.deliveryapi.api.dto.response.UserResponseDTO;
import com.misaeborges.deliveryapi.domain.models.User;
import com.misaeborges.deliveryapi.domain.repositories.IUserRepository;
import com.misaeborges.deliveryapi.domain.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserResponseAssembler userResponseAssembler;

    @Autowired
    private UserRequestDisassembler userRequestDisassembler;

    @GetMapping
    public List<UserResponseDTO> getAll() {
        return userResponseAssembler.toCollectionModel(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public UserResponseDTO findById(@PathVariable Long id) {
        return userResponseAssembler.toModel(userService.searchEngine(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO save(@RequestBody @Valid UserRequestDTO userRequestDTO) {

        User user = userRequestDisassembler.toDomainObject(userRequestDTO);

        return userResponseAssembler.toModel(userService.save(user));

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO update(@PathVariable Long id, @RequestBody @Valid UserRequestDTO userRequestDTO) {

        User user = userService.searchEngine(id);

        userRequestDisassembler.copyToDomainObject(userRequestDTO, user);

        return userResponseAssembler.toModel(userService.save(user));

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
