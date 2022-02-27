package com.example.assign1.Basket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class BasketRepositoryTest {

    @Autowired
    private BasketRepository basketRepository;

    @Test
    void findByUserId() {
        Basket basket = new Basket();
        basket.setUserId(0L);
        basketRepository.save(basket);

        Optional<Basket> result = basketRepository.findByUserId(0L);
        assertTrue(result.isPresent());

    }
}