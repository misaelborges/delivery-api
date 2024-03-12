package com.misaeborges.deliveryapi.api;

import com.misaeborges.deliveryapi.domain.dto.RestaurantRequestDTO;
import com.misaeborges.deliveryapi.domain.dto.RestaurantResponseDTO;
import com.misaeborges.deliveryapi.domain.model.Restaurant;
import com.misaeborges.deliveryapi.domain.repositories.IRestaurantRepository;
import com.misaeborges.deliveryapi.domain.services.RestaurantService;
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
    @ResponseStatus(HttpStatus.OK)
    public List<RestaurantResponseDTO> findAll() {
        return restaurantRepository.findAll().stream().map(RestaurantResponseDTO::new).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant save(@RequestBody RestaurantRequestDTO restaurant) {
        return restaurantService.save(restaurant);
    }

}
