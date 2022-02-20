package com.example.assign1.Product;


import lombok.Data;

@Data
public class ProductResponse {
    private Product product;

    public ProductResponse(){

    }

    public ProductResponse(Product product){
        this.product = product;
    }


}
