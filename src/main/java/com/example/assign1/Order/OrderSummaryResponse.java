package com.example.assign1.Order;

import com.example.assign1.Order.Payment.Payment;
import lombok.Data;
import lombok.Setter;

@Setter
@Data
public class OrderSummaryResponse {
    private Payment payment;
    private int amount;


}
