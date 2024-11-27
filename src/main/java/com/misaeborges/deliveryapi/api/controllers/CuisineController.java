package com.misaeborges.deliveryapi.api.controllers;

import com.misaeborges.deliveryapi.api.assemblers.CuisineRequestDisassembler;
import com.misaeborges.deliveryapi.api.assemblers.CuisineResponseAssembler;
import com.misaeborges.deliveryapi.api.dto.response.CuisineResponseDTO;
import com.misaeborges.deliveryapi.api.dto.request.CuisineResquestDTO;
import com.misaeborges.deliveryapi.domain.models.Cuisine;
import com.misaeborges.deliveryapi.domain.repositories.ICuisineRespository;
import com.misaeborges.deliveryapi.domain.services.CuisineService;
import jakarta.validation.Valid;
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

    @Autowired
    private CuisineResponseAssembler responseAssembler;

    @Autowired
    private CuisineRequestDisassembler cuisineRequestDisassembler;

    @GetMapping
    public List<CuisineResponseDTO> findAll() {
        return responseAssembler.toCollectionModel(cuisineRespository.findAll());
    }

    @GetMapping("/{id}")
    public CuisineResponseDTO findById(@PathVariable Long id) {
        return responseAssembler.toModel(cuisineService.searchEngine(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CuisineResponseDTO save(@RequestBody @Valid CuisineResquestDTO cuisineResquestDTO) {
        Cuisine cuisine = cuisineRequestDisassembler.toDomainObject(cuisineResquestDTO);

        return responseAssembler.toModel(cuisineService.save(cuisine));
    }

    @PutMapping("/{id}")
    public CuisineResponseDTO upload(@RequestBody @Valid CuisineResquestDTO cuisineData, @PathVariable Long id) {
        Cuisine cuisine = cuisineService.searchEngine(id);

        cuisineRequestDisassembler.copyToDomainObject(cuisineData, cuisine);

        return responseAssembler.toModel(cuisineService.save(cuisine));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        cuisineService.delete(id);
    }
}
