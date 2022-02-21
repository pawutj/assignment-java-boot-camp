package com.example.assign1.Basket;

public class BasketNotFoundException extends RuntimeException {
    public BasketNotFoundException(Long id) {
        super(String.valueOf(id));
    }
}
