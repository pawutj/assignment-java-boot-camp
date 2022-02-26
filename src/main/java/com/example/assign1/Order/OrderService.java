package com.example.assign1.Order;

import com.example.assign1.Basket.Basket;
import com.example.assign1.Basket.BasketRepository;
import com.example.assign1.Basket.BasketService;
import com.example.assign1.MockAPI.MockPaymentResPonse;
import com.example.assign1.Order.Address.Address;
import com.example.assign1.Order.Address.AddressRepository;
import com.example.assign1.Order.Payment.Payment;
import com.example.assign1.Order.Payment.PaymentRepository;
import com.example.assign1.Product.Product;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.Setter;

import java.net.URI;
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

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ConnectMockPaymentService connectMockPaymentService;

    public OrderSummaryResponse getOrderSummaryById(Long id){
        Optional<Order> orderOptional = orderRepository.findById(id);
        Order order = orderOptional.get();

        int amount=0;
        for(Product p  : order.getProducts()){
            amount+=p.getPrice();
        }

        OrderSummaryResponse orderSummaryResponse = new OrderSummaryResponse();
        orderSummaryResponse.setPayment( order.getPayment());
        orderSummaryResponse.setAmount(amount);

        return orderSummaryResponse;

    }

    public Order setAddressById(Address address, Long id) {
        Address addressResult = addressRepository.save(address);
        Optional<Order> orderResult = orderRepository.findById(id);
        Order order = orderResult.get();
        order.setAddress(addressResult);
        Order result = orderRepository.save(order);
        return result;
    }

    public Order setPaymentById(Payment payment, Long id) {
        Payment paymentResult = paymentRepository.save(payment);

        Optional<Order> orderResult = orderRepository.findById(id);
        Order order = orderResult.get();
        order.setPayment(paymentResult);

        Order result = orderRepository.save(order);

        return result;
    }

    public Order Checkout(Long userId) {
        Optional<Basket> basket = basketRepository.findByUserId(userId);
        List<Product> products = basket.get().getProducts();
        Basket emptyBasket = basketService.CleanBasket(userId);

        Order order = new Order();
        order.setProducts(products);
        order.setOrderStatus(OrderStatus.pedding);
        Order result = orderRepository.save(order);

        return result;

    }


    public Order CheckIsPaid(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        Order order = orderOptional.get();

        Boolean isPaid = connectMockPaymentService.getIsPaidFromMockAPI(orderId);

        if (isPaid)
            order.setOrderStatus(OrderStatus.complate);

        Order result = orderRepository.save(order);
        return result;
    }

}