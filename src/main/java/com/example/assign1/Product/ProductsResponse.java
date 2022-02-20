package com.example.assign1.Product;

import lombok.Data;
import java.util.List;


@Data
public class ProductsResponse {

    private List<Product> products;

    ProductsResponse(){}

    ProductsResponse(List<Product> products){
        this.products = products;

    }

}
