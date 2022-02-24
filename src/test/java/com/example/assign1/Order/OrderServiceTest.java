package com.example.assign1.Order;

import com.example.assign1.Order.Address.AddressRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.example.assign1.Order.Address.Address;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private OrderRepository orderRepository;

    @Test
    void setAddressById() {

        Address address = new Address();
        address.setAddress("Test Address");

        Order order = new Order();

        Order orderWithAddress = new Order();
        orderWithAddress.setAddress(address);

        Long id = 0L;

        when(orderRepository.findById(id)).thenReturn(Optional.of(order));
        when(addressRepository.save(address)).thenReturn(address);
        when(orderRepository.save(orderWithAddress)).thenReturn(orderWithAddress);

        OrderService orderService = new OrderService();
        orderService.setOrderRepository(orderRepository);
        orderService.setAddressRepository(addressRepository);

        Order result = orderService.setAddressById(address, 0L);

        assertEquals(result, orderWithAddress);

    }

}
