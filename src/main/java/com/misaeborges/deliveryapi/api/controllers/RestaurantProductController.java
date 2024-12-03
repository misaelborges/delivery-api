package com.misaeborges.deliveryapi.api.controllers;

import com.misaeborges.deliveryapi.api.assemblers.ProductRequestDisassembler;
import com.misaeborges.deliveryapi.api.assemblers.ProductResponseAssembler;
import com.misaeborges.deliveryapi.api.dto.request.ProductRequestDTO;
import com.misaeborges.deliveryapi.api.dto.response.ProductResponseDTO;
import com.misaeborges.deliveryapi.domain.models.Product;
import com.misaeborges.deliveryapi.domain.models.Restaurant;
import com.misaeborges.deliveryapi.domain.repositories.IProductRepository;
import com.misaeborges.deliveryapi.domain.services.ProductService;
import com.misaeborges.deliveryapi.domain.services.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restaurants/{restaurantId}/products")
public class RestaurantProductController {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private ProductResponseAssembler productResponseAssembler;

    @Autowired
    ProductRequestDisassembler productRequestDisassembler;

    @GetMapping
    public List<ProductResponseDTO> getAll(@PathVariable Long restaurantId) {
        Restaurant restaurant = restaurantService.searchEngine(restaurantId);
        return productResponseAssembler.toCollectionModell(restaurant.getProducts());
    }

    @GetMapping("/{productId}")
    public ProductResponseDTO findById(@PathVariable Long restaurantId, @PathVariable Long productId) {
        Restaurant restaurant = restaurantService.searchEngine(restaurantId);
        return productResponseAssembler.toModell(productService.findById(restaurantId, productId));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDTO save(@PathVariable Long restaurantId, @RequestBody @Valid ProductRequestDTO productRequestDTO) {
        Restaurant restaurant = restaurantService.searchEngine(restaurantId);

        Product product = productRequestDisassembler.toDomainObject(productRequestDTO);
        product.setRestaurant(restaurant);

        return productResponseAssembler.toModell(productService.save(product));
    }

    @PutMapping("/{productId}")
    public ProductResponseDTO Update(@PathVariable Long restaurantId,
                                     @PathVariable Long productId,
                                     @RequestBody @Valid ProductRequestDTO productRequestDTO)
    {
        Product product = productService.searchEngine(productId);
        Restaurant restaurant = restaurantService.searchEngine(restaurantId);

        productRequestDisassembler.copyToDomainObject(productRequestDTO, product);

        return productResponseAssembler.toModell(productService.save(product));
    }
}
