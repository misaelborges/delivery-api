package com.misaeborges.deliveryapi.domain.repositories;

import com.misaeborges.deliveryapi.domain.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission, Long> {
}
