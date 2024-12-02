package com.misaeborges.deliveryapi.api.controllers;

import com.misaeborges.deliveryapi.api.assemblers.PaymentMethdoAssembler;
import com.misaeborges.deliveryapi.api.assemblers.PaymentMethdoDisassembler;
import com.misaeborges.deliveryapi.api.dto.request.PaymentMethodRequestDTO;
import com.misaeborges.deliveryapi.api.dto.response.PaymentMethodResponseDTO;
import com.misaeborges.deliveryapi.domain.models.PaymentMethod;
import com.misaeborges.deliveryapi.domain.repositories.IPaymentMethodRepository;
import com.misaeborges.deliveryapi.domain.services.PaymenteMethodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymentMethod")
public class PaymentMethodController {

    @Autowired
    private PaymenteMethodService paymenteMethodService;

    @Autowired
    private IPaymentMethodRepository paymentMethodRepository;

    @Autowired
    private PaymentMethdoAssembler paymentMethdoAssembler;

    @Autowired
    private PaymentMethdoDisassembler paymentMethdoDisassembler;

    @GetMapping
    public List<PaymentMethodResponseDTO> findAll() {
        return paymentMethdoAssembler.toCollectionModel(paymentMethodRepository.findAll());
    }

    @GetMapping("/{id}")
    public PaymentMethodResponseDTO findById(@PathVariable Long id) {
        return paymentMethdoAssembler.toModel(paymenteMethodService.searchEngine(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentMethodResponseDTO save(@RequestBody @Valid PaymentMethodRequestDTO paymentMethodRequestDTO) {
        PaymentMethod paymentMethod = paymentMethdoDisassembler.toModel(paymentMethodRequestDTO);
        return paymentMethdoAssembler.toModel(paymenteMethodService.save(paymentMethod));
    }

    @PutMapping("/{id}")
    public PaymentMethodResponseDTO update(@PathVariable Long id, @RequestBody @Valid PaymentMethodRequestDTO paymentMethodRequestDTO) {
        PaymentMethod paymentMethod = paymenteMethodService.searchEngine(id);

        paymentMethdoDisassembler.toCollectionModel(paymentMethodRequestDTO, paymentMethod);

        return paymentMethdoAssembler.toModel(paymenteMethodService.save(paymentMethod));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paymenteMethodService.delete(id);
    }
}
