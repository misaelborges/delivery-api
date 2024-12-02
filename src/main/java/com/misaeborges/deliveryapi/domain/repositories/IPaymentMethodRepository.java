package com.misaeborges.deliveryapi.domain.repositories;

import com.misaeborges.deliveryapi.domain.models.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
