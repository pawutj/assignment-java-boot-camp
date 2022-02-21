package com.example.assign1.Basket;

import com.example.assign1.Product.Product;
import lombok.Data;
import java.util.List;

@Data
public class Basket {
    private List<Product> products;
    private Long userId;

}
