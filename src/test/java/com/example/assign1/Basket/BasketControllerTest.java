package com.example.assign1.Basket;

import com.example.assign1.Product.Product;
import com.example.assign1.Product.ProductIdRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BasketControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private BasketService basketService;

    @Test
    void findBasketByUserId() {
        Basket basket = new Basket();
        basket.setUserId(0L);

        when(basketService.findBasketByUserId(0L)).thenReturn(basket);

        BasketResponse result = testRestTemplate.getForObject("/basket/findBasketByUserId/0",BasketResponse.class);
        assertEquals(result.getBasket().getUserId(),0);
    }

    @Test
    void addProductToBasketByUserId() {
        Basket basket = new Basket();
        Product product = new Product();
        basket.setProducts(List.of(product));
        ProductIdRequest productIdRequest = new ProductIdRequest(0L);

        when(basketService.addProductToBasketByUserId(0L,0L)).thenReturn(basket);

        BasketResponse result = testRestTemplate.postForObject("/basket/addProductToBasketByUserId/0",productIdRequest,BasketResponse.class);
        assertEquals(result.getBasket().getProducts().size(),1);


    }
}