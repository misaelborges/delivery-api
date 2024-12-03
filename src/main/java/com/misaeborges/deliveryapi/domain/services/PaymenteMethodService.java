package com.misaeborges.deliveryapi.domain.services;

import com.misaeborges.deliveryapi.domain.exception.EntityInUseException;
import com.misaeborges.deliveryapi.domain.exception.PaymentMethodNotFoundException;
import com.misaeborges.deliveryapi.domain.models.PaymentMethod;
import com.misaeborges.deliveryapi.domain.repositories.IPaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymenteMethodService {

    @Autowired
    private IPaymentMethodRepository paymentMethodRepository;

    @Transactional
    public PaymentMethod save(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Transactional
    public void delete(Long id) {
        PaymentMethod paymentMethod = searchEngine(id);
        try {
            paymentMethodRepository.deleteById(paymentMethod.getId());
        } catch (EmptyResultDataAccessException e) {
            throw new PaymentMethodNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(id);
        }
    }

    public PaymentMethod searchEngine(Long id) {
        return paymentMethodRepository.findById(id).orElseThrow(() -> new PaymentMethodNotFoundException(id));
    }


}
