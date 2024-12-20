package com.misaeborges.deliveryapi.api.controllers;

import com.misaeborges.deliveryapi.api.assemblers.CityRequestDisassembler;
import com.misaeborges.deliveryapi.api.assemblers.CityResponseAssembler;
import com.misaeborges.deliveryapi.api.dto.request.CityRequestDTO;
import com.misaeborges.deliveryapi.api.dto.response.CityResponseDTO;
import com.misaeborges.deliveryapi.domain.models.City;
import com.misaeborges.deliveryapi.domain.repositories.ICityRepository;
import com.misaeborges.deliveryapi.domain.services.CityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private ICityRepository cityRepository;

    @Autowired
    private CityResponseAssembler cityResponseAssembler;

    @Autowired
    private CityRequestDisassembler cityRequestDisassembler;

    @GetMapping
    public List<CityResponseDTO> getAll() {
        return cityResponseAssembler.toCollectionModell(cityRepository.findAll());
    }

    @GetMapping("/{id}")
    public CityResponseDTO getById(@PathVariable Long id) {
        return cityResponseAssembler.toModell(cityService.searchEngine(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CityResponseDTO save(@RequestBody @Valid CityRequestDTO cityRequestDTO) {
        City city = cityRequestDisassembler.toDomainObject(cityRequestDTO);

        return cityResponseAssembler.toModell(cityService.save(city));
    }

    @PutMapping("/{id}")
    public CityResponseDTO update(@PathVariable Long id, @RequestBody @Valid CityRequestDTO cityRequestDTO) {
        City city = cityService.searchEngine(id);

        cityRequestDisassembler.copyToDomainObject(cityRequestDTO, city);

        return cityResponseAssembler.toModell(cityService.save(city));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        cityService.delete(id);
    }

}
