package com.example.assign1.Order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    @Test
    void findById() {
        Order order = new Order();
        order.setUserId(0L);

        Order repoOrder = orderRepository.save(order);
        Long id = repoOrder.getId();

        Optional<Order> result = orderRepository.findById(id);
        assertTrue(result.isPresent());

    }

}
