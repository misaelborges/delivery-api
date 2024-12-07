package com.misaeborges.deliveryapi.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private BigDecimal subtotal;
    private BigDecimal shippingFee;
    private BigDecimal totalValue;

    @Embedded
    private Address address;

    @CreationTimestamp
    private LocalDate creationDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDate confirmationDate;
    private LocalDate cancellationDate;
    private LocalDate deliveryDate;

    @ManyToOne
    @JoinColumn(nullable = false)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "customer_user_id", nullable = false)
    private User customerId;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItem = new ArrayList<>();
}
