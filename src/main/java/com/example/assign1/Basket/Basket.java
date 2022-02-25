package com.example.assign1.Basket;

import com.example.assign1.Product.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
    private List<Product> products;

    private Long userId;

    public Basket() {
        this.products = new ArrayList<>();
    }

}
