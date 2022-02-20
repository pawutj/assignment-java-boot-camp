package com.example.assign1.Product;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Setter
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findProductsByName(String name){
        return productRepository.findByProductName(name);
    }

    public Product findById(Long id){
        Optional<Product> result = productRepository.findById(id);
        if (result.isPresent()) {
                return result.get();
            }
        throw new ProductNotFoundException(id);

    }

}
