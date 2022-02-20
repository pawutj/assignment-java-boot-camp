package com.example.assign1.Product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.mockito.Mockito.when;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ProductService productService;

    @Test
    void findProductsByName() {
        Product product = new Product();
        product.setProductName("test");

        List<Product> products = List.of(product);

        when(productService.findProductsByName("test")).thenReturn(products);

        ProductsResponse result = testRestTemplate.getForObject("/product/findProductsByName/test",ProductsResponse.class);
        assertEquals(result.getProducts().size(),1);
    }

    @Test
    void findProductById(){
        Product product = new Product();
        product.setProductName("test");

        when(productService.findById(0L)).thenReturn(product);

        ProductResponse result = testRestTemplate.getForObject("/product/findProductById/0",ProductResponse.class);
        assertEquals(result.getProduct().getProductName(),"test");
    }
}