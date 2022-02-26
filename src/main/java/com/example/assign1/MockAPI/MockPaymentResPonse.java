package com.example.assign1.MockAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@Data
public class MockPaymentResPonse {

    private Long orderId;
    private Boolean isPaid;

    MockPaymentResPonse() {
    }

    MockPaymentResPonse(Long orderId, Boolean isPaid) {
        this.orderId = orderId;
        this.isPaid = isPaid;
    }
}
