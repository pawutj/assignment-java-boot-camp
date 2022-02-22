package com.example.assign1.Basket;

import lombok.Data;

@Data
public class BasketResponse {
    private Basket basket;

    public BasketResponse(){

    }

    public BasketResponse(Basket basket){
        this.basket = basket;
    }
}
