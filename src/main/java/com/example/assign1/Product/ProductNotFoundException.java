package com.example.assign1.Product;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super(String.valueOf(id));
    }
}
