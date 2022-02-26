package com.example.assign1.Product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Test
    void findProductsByName() {
        Product product = new Product();
        product.setProductName("test");
        String productName = "test";
        when(productRepository.findByProductNameContaining(productName)).thenReturn(List.of(product));

        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);

        List<Product> result = productService.findProductsByName(productName);
        assertEquals(result.size(),1);

    }

    @Test
    void findById() {

        Product product = new Product();
        product.setProductName("test");
        Long id = 0L;
        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);

        Product result = productService.findById(id);
        assertEquals(result.getProductName(),"test");

    }
}