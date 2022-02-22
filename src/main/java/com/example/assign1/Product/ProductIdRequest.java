package com.example.assign1.Product;

import lombok.Data;

@Data
public class ProductIdRequest {
    private Long productId;
    public ProductIdRequest(){}
    public ProductIdRequest(Long productId){
        this.productId = productId;
    }
}
