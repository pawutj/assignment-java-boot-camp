package com.example.assign1.Basket;

import com.example.assign1.Product.Product;
import com.example.assign1.Product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BasketServiceTest {

    @Mock
    BasketRepository basketRepository;

    @Mock
    ProductRepository productRepository;

    @Test
    void findBasketByUserId() {
        Basket basket = new Basket();
        basket.setUserId(0L);

        when(basketRepository.findByUserId(0L)).thenReturn(Optional.of(basket));

        Optional<Basket> result = basketRepository.findByUserId(0L);

        assertEquals(result.get().getUserId(), 0L);

    }

    @Test
    void addProductToBasketByUserId() {
        Basket basket = new Basket();
        Product product = new Product();
        product.setProductName("test");
        Basket basketWithProduct = new Basket();
        basketWithProduct.setProducts(List.of(product));

        when(basketRepository.findByUserId(0L)).thenReturn(Optional.of(basket));
        when(basketRepository.save(basket)).thenReturn(basketWithProduct);
        when(productRepository.findById(0L)).thenReturn(Optional.of(product));

        BasketService basketService = new BasketService();
        basketService.setBasketRepository(basketRepository);
        basketService.setProductRepository(productRepository);

        Basket result = basketService.addProductToBasketByUserId(0L, 0L);

        assertEquals(result.getProducts().size(), 1);

    }

    @Test
    void CleanBasket() {
        Basket basketWithProducts = new Basket();
        Product product = new Product();
        basketWithProducts.setProducts(List.of(product));

        Basket basket = new Basket();

        when(basketRepository.findByUserId(0L)).thenReturn(Optional.of(basket));
        when(basketRepository.save(basket)).thenReturn(basket);

        BasketService basketService = new BasketService();
        basketService.setBasketRepository(basketRepository);
        basketService.setProductRepository(productRepository);

        Basket result = basketService.CleanBasket(0L);
        assertEquals(result.getProducts().size(), 0);

    }

}