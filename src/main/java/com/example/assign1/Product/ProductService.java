package com.example.assign1.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findProductsByName(String name){
        return productRepository.findByProductName(name);
    }

}
