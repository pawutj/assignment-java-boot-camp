package com.example.assign1.Order;

public class OrderNotFoundException extends  RuntimeException{

    public OrderNotFoundException(Long id){
        super(String.valueOf(id));
    }
}
