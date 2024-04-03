package com.misaeborges.deliveryapi.api;

import com.misaeborges.deliveryapi.domain.dto.CuisineResponseDTO;
import com.misaeborges.deliveryapi.domain.dto.CuisineResquestDTO;
import com.misaeborges.deliveryapi.domain.model.Cuisine;
import com.misaeborges.deliveryapi.domain.repositories.ICuisineRespository;
import com.misaeborges.deliveryapi.domain.services.CuisineService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuisinis")
public class CuisineController {

    @Autowired
    private CuisineService cuisineService;

    @Autowired
    private ICuisineRespository cuisineRespository;

    @GetMapping
    public List<CuisineResponseDTO> findAll() {
        return cuisineRespository.findAll().stream().map(CuisineResponseDTO::new).toList();
    }

    @GetMapping("/{id}")
    public Cuisine findById(@PathVariable Long id) {
        return cuisineService.searchEngine(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cuisine save(@RequestBody CuisineResquestDTO cuisineResquestDTO) {
        return cuisineService.save(cuisineResquestDTO);
    }

    @PutMapping("/{id}")
    public Cuisine upload(@RequestBody CuisineResquestDTO cuisineData, @PathVariable Long id) {
        Cuisine cuisine = cuisineService.searchEngine(id);

        BeanUtils.copyProperties(cuisineData, cuisine, "id");
        return cuisineRespository.save(cuisine);
    }
}
