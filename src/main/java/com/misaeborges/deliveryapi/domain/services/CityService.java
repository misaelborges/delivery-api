package com.misaeborges.deliveryapi.domain.services;

import com.misaeborges.deliveryapi.domain.exception.CityNotFoundException;
import com.misaeborges.deliveryapi.domain.exception.EntityInUseException;
import com.misaeborges.deliveryapi.domain.models.City;
import com.misaeborges.deliveryapi.domain.models.State;
import com.misaeborges.deliveryapi.domain.repositories.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CityService {

    @Autowired
    private ICityRepository cityRepository;

    @Autowired
    private StateService stateService;

    @Transactional
    public City save(City city) {
        State state = stateService.searchEngine(city.getState().getId());

        city.setState(state);

        return cityRepository.save(city);
    }

    @Transactional
    public void delete(Long id) {
        try {
            cityRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new CityNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(id);
        }
    }

    public City searchEngine(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException(id));
    }
}
