package com.misaeborges.deliveryapi.domain.repositories;

import com.misaeborges.deliveryapi.domain.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("""
            SELECT p
            FROM Product p
            JOIN p.restaurant r
            WHERE r.id = :restaurantId AND p.id = :productId
            """)
    Product findById(@Param("restaurantId") Long restaurantId, @Param("productId") Long productId);
}
