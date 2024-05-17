package com.misaeborges.deliveryapi.api.controllers;

import com.misaeborges.deliveryapi.domain.dto.RestaurantRequestDTO;
import com.misaeborges.deliveryapi.domain.dto.RestaurantResponseDTO;
import com.misaeborges.deliveryapi.domain.models.Restaurant;
import com.misaeborges.deliveryapi.domain.repositories.IRestaurantRepository;
import com.misaeborges.deliveryapi.domain.services.RestaurantService;
import org.springframework.beans.BeanUtils;
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

    @GetMapping
    public List<RestaurantResponseDTO> findAll() {
        return restaurantRepository.findAll().stream().map(RestaurantResponseDTO::new).toList();
    }

    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable Long id) {
        return restaurantService.searchEngine(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant save(@RequestBody RestaurantRequestDTO restaurant) {
        return restaurantService.save(restaurant);
    }

    @PutMapping("/{id}")
    public Restaurant update(@RequestBody RestaurantRequestDTO restaurantData, @PathVariable Long id) {
        Restaurant restaurant = restaurantService.searchEngine(id);

        BeanUtils.copyProperties(restaurantData, restaurant, "id", "registrationDate");
        return restaurantRepository.save(restaurant);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        restaurantService.delete(id);
    }

}
