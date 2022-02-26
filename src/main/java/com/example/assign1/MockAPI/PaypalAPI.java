package com.example.assign1.MockAPI;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaypalAPI {
    @GetMapping("/mockup/paypal/{orderId}")
    public MockPaymentResPonse getPaypalAPI(@PathVariable Long orderId) {
        return new MockPaymentResPonse(orderId, true);
    }
}
