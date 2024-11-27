package com.misaeborges.deliveryapi.api.controllers;

import com.misaeborges.deliveryapi.api.assemblers.RestaurantRequestDisassembler;
import com.misaeborges.deliveryapi.api.assemblers.RestaurantResponseAssembler;
import com.misaeborges.deliveryapi.api.dto.request.RestaurantRequestDTO;
import com.misaeborges.deliveryapi.api.dto.response.RestaurantResponseDTO;
import com.misaeborges.deliveryapi.domain.models.Restaurant;
import com.misaeborges.deliveryapi.domain.repositories.IRestaurantRepository;
import com.misaeborges.deliveryapi.domain.services.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private IRestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantResponseAssembler restaurantResponseAssembler;

    @Autowired
    private RestaurantRequestDisassembler restaurantRequestDisassembler;

    @GetMapping
    public List<RestaurantResponseDTO> findAll() {
        return restaurantResponseAssembler.toCollectionModel(restaurantRepository.findAll());
    }

    @GetMapping("/{id}")
    public RestaurantResponseDTO findById(@PathVariable Long id) {
        return restaurantResponseAssembler.toModel(restaurantService.searchEngine(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantResponseDTO save(@RequestBody @Valid RestaurantRequestDTO requestDTO) {
        Restaurant restaurant = restaurantRequestDisassembler.toDomainObject(requestDTO);
        return restaurantResponseAssembler.toModel(restaurantService.save(restaurant));
    }

    @PutMapping("/{id}")
    public RestaurantResponseDTO update(@RequestBody RestaurantRequestDTO restaurantData, @PathVariable Long id) {
        Restaurant restaurant = restaurantService.searchEngine(id);

        restaurantRequestDisassembler.copyToDomainObject(restaurantData, restaurant);

        return restaurantResponseAssembler.toModel(restaurantRepository.save(restaurant));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        restaurantService.delete(id);
    }

}
