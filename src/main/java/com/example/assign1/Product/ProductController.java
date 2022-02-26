package com.example.assign1.Product;


import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@Setter
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/findProductsByName/{name}")
    public ProductsResponse findProductsByName(@PathVariable String name){
        List<Product> result = productService.findProductsByName(name);
        return new ProductsResponse(result);
    }

    @GetMapping("/product/findProductById/{id}")
    public ProductResponse findProductById(@PathVariable Long id){
        Product result = productService.findById(id);
        return new ProductResponse(result);
    }


}
