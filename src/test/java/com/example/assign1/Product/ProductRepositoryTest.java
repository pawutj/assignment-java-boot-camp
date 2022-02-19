package com.example.assign1.Product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByProductName() {

        Product product = new Product();
        product.setProductName("testing");
        productRepository.save(product);
        List<Product> result =  productRepository.findByProductName("testing");
        assertTrue(result.size()>=1);
    }
    @Test
    void findById(){
        Product product = new Product();
        product.setProductName("testing");
        Product _product = productRepository.save(product);
        Optional<Product> result = productRepository.findById(_product.getId());
        assertTrue(result.isPresent());
    }
}