package com.example.assign1.Order;

import com.example.assign1.Product.Product;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;
@Data
@Entity
public class Order {

    @ManyToMany
    private List<Product> products;
    private Long userId;

}
