package com.example.assign1.Order;

import com.example.assign1.Order.Address.Address;
import com.example.assign1.Order.Address.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import lombok.Setter;
import java.util.Optional;

@Service
@Setter
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Order setAddressById(Address address, Long id) {
        Address addressResult = addressRepository.save(address);
        Optional<Order> orderResult = orderRepository.findById(id);
        Order order = orderResult.get();
        order.setAddress(addressResult);
        Order result = orderRepository.save(order);
        return result;
    }

}