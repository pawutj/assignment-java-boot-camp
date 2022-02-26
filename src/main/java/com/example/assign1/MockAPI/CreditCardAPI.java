package com.example.assign1.MockAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCardAPI {
    @GetMapping("/mockup/creditcard/{orderId}")
    public MockPaymentResPonse getCreditCardAPI(@PathVariable Long orderId) {
        return new MockPaymentResPonse(orderId, true);

    }

}
