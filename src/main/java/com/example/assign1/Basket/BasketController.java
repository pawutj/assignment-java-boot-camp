package com.example.assign1.Basket;

import com.example.assign1.Product.ProductIdRequest;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Setter
@RestController
public class BasketController {
    @Autowired
    BasketService basketService;

    @GetMapping("/basket/findBasketByUserId/{userId}")
    public BasketResponse findBasketByUserId(@PathVariable Long userId){
        Basket result = basketService.findBasketByUserId(userId);
        return  new BasketResponse(result);
    }

    @PostMapping("/basket/addProductToBasketByUserId/{userId}")
    public BasketResponse addProductToBasketByUserId(@RequestBody ProductIdRequest productIdRequest, @PathVariable Long userId){
        Long productId = productIdRequest.getProductId();
        Basket result = basketService.addProductToBasketByUserId(productId, userId);
        return new BasketResponse(result);
    }

}
