package com.example.assign1.Order;

import com.example.assign1.Basket.Basket;
import com.example.assign1.Basket.BasketRepository;
import com.example.assign1.Basket.BasketService;
import com.example.assign1.Order.Address.Address;
import com.example.assign1.Order.Address.AddressRepository;
import com.example.assign1.Product.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Service
@Setter
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private BasketService basketService;

    public Order setAddressById(Address address, Long id) {
        Address addressResult = addressRepository.save(address);
        Optional<Order> orderResult = orderRepository.findById(id);
        Order order = orderResult.get();
        order.setAddress(addressResult);
        Order result = orderRepository.save(order);
        return result;
    }

    public Order Checkout(Long userId) {
        Optional<Basket> basket = basketRepository.findByUserId(userId);
        List<Product> products = basket.get().getProducts();
        Basket emptyBasket = basketService.CleanBasket(userId);

        Order order = new Order();
        order.setProducts(products);
        Order result = orderRepository.save(order);

        return result;

    }

}