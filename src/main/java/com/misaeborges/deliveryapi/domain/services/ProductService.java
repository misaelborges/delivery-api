package com.misaeborges.deliveryapi.domain.services;

import com.misaeborges.deliveryapi.domain.exception.ProductNotFoundException;
import com.misaeborges.deliveryapi.domain.models.Product;
import com.misaeborges.deliveryapi.domain.models.Restaurant;
import com.misaeborges.deliveryapi.domain.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private RestaurantService restaurantService;


    public Product findById(Long restaurantId, Long productId) {
        return productRepository.findById(restaurantId, productId);
    }

    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);

    }

    public Product searchEngine(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

}
