package com.example.assign1.Order;

import com.example.assign1.Product.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import com.example.assign1.Order.Address.Address;
import javax.persistence.Column;
import com.example.assign1.Order.Payment.Payment;

@Data
@Entity
public class Order {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ManyToMany
    private List<Product> products;
    private Long userId;

    @OneToOne
    private Address address;

    @OneToOne
    private Payment payment;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
