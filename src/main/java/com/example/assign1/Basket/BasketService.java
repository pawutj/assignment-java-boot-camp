package com.example.assign1.Basket;

import com.example.assign1.Product.Product;
import com.example.assign1.Product.ProductRepository;
import com.example.assign1.Product.ProductResponse;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Setter
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private ProductRepository productRepository;

    public Basket findBasketByUserId(Long userId) {
        Optional<Basket> result = basketRepository.findByUserId(userId);
        if (result.isPresent()) {
            return result.get();
        }
        throw new BasketNotFoundException(userId);
    }

    public Basket addProductToBasketByUserId(Long productId, Long userId) {
        Optional<Basket> oldBasket = basketRepository.findByUserId(userId);
        Optional<Product> product = productRepository.findById(productId);
        if (oldBasket.isPresent() && product.isPresent()) {
            Basket basket = oldBasket.get();
            List<Product> products = basket.getProducts();
            products.add(product.get());

            Basket result = basketRepository.save(basket);
            return result;
        }
        throw new BasketNotFoundException(userId);
    }

    public Basket CleanBasket(Long userId) {
        Optional<Basket> basketOptional = basketRepository.findByUserId(userId);
        Basket basket = basketOptional.get();

        basket.setProducts(List.of());
        Basket result = basketRepository.save(basket);

        return result;
    }

}
