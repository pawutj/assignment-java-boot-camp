package com.example.assign1.Order;

import lombok.Data;

@Data
public class OrderResponse {
    private Order order;

    public OrderResponse() {
    }

    public OrderResponse(Order order) {
        this.order = order;
    }
}
