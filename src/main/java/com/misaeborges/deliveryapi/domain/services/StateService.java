package com.misaeborges.deliveryapi.domain.services;

import com.misaeborges.deliveryapi.domain.exception.EntityInUseException;
import com.misaeborges.deliveryapi.domain.exception.StateNotFoundException;
import com.misaeborges.deliveryapi.domain.models.State;
import com.misaeborges.deliveryapi.domain.repositories.IStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StateService {

    @Autowired
    private IStateRepository stateRepository;

    @Transactional
    public State save(State state) {
        return stateRepository.save(state);
    }

    @Transactional
    public void delete(Long id) {
        try {
            stateRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new StateNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(id);
        }
    }

    public State searchEngine(Long id) {
        return stateRepository.findById(id).orElseThrow(() -> new StateNotFoundException(id));
    }
}
