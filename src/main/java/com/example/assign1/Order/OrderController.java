package com.example.assign1.Order;

import com.example.assign1.Order.Address.Address;

import com.example.assign1.Order.Payment.Payment;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Setter
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/order/getOrderSummary/{id}")
    public OrderSummaryResponse getOrderSummary(@PathVariable Long id){
        OrderSummaryResponse result = orderService.getOrderSummaryById(id);
        return result;
    }

    @PostMapping("/order/setAddressById/{id}")
    public OrderResponse setAddressById(@RequestBody Address address, @PathVariable Long id) {
        Order result = orderService.setAddressById(address, id);

        return new OrderResponse(result);
    }

    @PostMapping("/order/setPaymentById/{id}")
    public OrderResponse setPaymentById(@RequestBody Payment payment , @PathVariable Long id){
        Order result = orderService.setPaymentById(payment,id);
        return new OrderResponse(result);
    }

    @GetMapping("/order/checkout/{userId}")
    public OrderResponse checkout(@PathVariable Long userId) {
        Order result = orderService.Checkout(userId);
        return new OrderResponse(result);
    }

}
