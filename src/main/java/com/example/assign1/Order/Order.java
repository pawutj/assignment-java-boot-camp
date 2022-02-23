package com.example.assign1.Order;

import com.example.assign1.Product.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Order {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ManyToMany
    private List<Product> products;
    private Long userId;


}
