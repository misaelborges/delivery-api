package com.misaeborges.deliveryapi.api;

import com.misaeborges.deliveryapi.domain.dto.CuisineResquestDTO;
import com.misaeborges.deliveryapi.domain.model.Cuisine;
import com.misaeborges.deliveryapi.domain.services.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuisinis")
public class CuisineController {

    @Autowired
    private CuisineService cuisineService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cuisine save(@RequestBody CuisineResquestDTO cuisineResquestDTO) {
        return cuisineService.save(cuisineResquestDTO);
    }
}
