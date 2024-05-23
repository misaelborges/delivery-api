package com.misaeborges.deliveryapi.domain.services;

import com.misaeborges.deliveryapi.domain.exception.EntityInUseException;
import com.misaeborges.deliveryapi.domain.exception.PermissionNotFoundException;
import com.misaeborges.deliveryapi.domain.models.Permission;
import com.misaeborges.deliveryapi.domain.repositories.IPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PermissionService {

    @Autowired
    private IPermissionRepository permissionRepository;

    @Transactional
    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Transactional
    public void delete(Long id) {
        try {
            searchEngine(id);
            permissionRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new PermissionNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(id);
        }
    }

    public Permission searchEngine(Long id) {
        return permissionRepository.findById(id).orElseThrow(() -> new PermissionNotFoundException(id));
    }
}
