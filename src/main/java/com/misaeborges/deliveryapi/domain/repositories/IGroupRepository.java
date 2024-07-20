package com.misaeborges.deliveryapi.domain.repositories;

import com.misaeborges.deliveryapi.domain.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGroupRepository extends JpaRepository<Group, Long> {
}
