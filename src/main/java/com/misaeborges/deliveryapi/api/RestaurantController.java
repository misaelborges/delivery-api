package com.misaeborges.deliveryapi.api;

import com.misaeborges.deliveryapi.domain.dto.RestaurantRequestDTO;
import com.misaeborges.deliveryapi.domain.model.Restaurant;
import com.misaeborges.deliveryapi.domain.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant save(@RequestBody RestaurantRequestDTO restaurant) {
        return restaurantService.save(restaurant);
    }

}
