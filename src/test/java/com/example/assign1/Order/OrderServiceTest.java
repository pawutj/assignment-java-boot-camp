package com.example.assign1.Order;

import com.example.assign1.Order.Address.AddressRepository;
import com.example.assign1.Order.Payment.PaymentRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.assign1.Basket.Basket;
import com.example.assign1.Basket.BasketRepository;
import com.example.assign1.Basket.BasketService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.assign1.Order.Address.Address;
import com.example.assign1.Order.Payment.Payment;
import com.example.assign1.Product.Product;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private BasketRepository basketRepository;

    @Mock
    private BasketService basketService;

    @Mock
    private ConnectMockPaymentService connectMockPaymentService;

    @Mock
    private PaymentRepository paymentRepository;

    @Test
    void setPaymentById() {
        Payment payment = new Payment();
        payment.setName("test");

        Order order = new Order();

        Order orderWithPayment = new Order();
        orderWithPayment.setPayment(payment);

        Long id = 0L;

        when(orderRepository.findById(id)).thenReturn(Optional.of(order));
        when(paymentRepository.save(payment)).thenReturn(payment);
        when(orderRepository.save(orderWithPayment)).thenReturn(orderWithPayment);

        OrderService orderService = new OrderService();
        orderService.setOrderRepository(orderRepository);
        orderService.setPaymentRepository(paymentRepository);

        Order result = orderService.setPaymentById(payment, id);
        assertEquals(result.getPayment().getName(), "test");

    }

    @Test
    void setAddressById() {

        Address address = new Address();
        address.setAddress("Test Address");

        Order order = new Order();

        Order orderWithAddress = new Order();
        orderWithAddress.setAddress(address);

        Long id = 0L;

        when(orderRepository.findById(id)).thenReturn(Optional.of(order));
        when(addressRepository.save(address)).thenReturn(address);
        when(orderRepository.save(orderWithAddress)).thenReturn(orderWithAddress);

        OrderService orderService = new OrderService();
        orderService.setOrderRepository(orderRepository);
        orderService.setAddressRepository(addressRepository);

        Order result = orderService.setAddressById(address, 0L);

        assertEquals(result, orderWithAddress);

    }

    @Test
    void CheckIsPaid() {

        Order order = new Order();
        Order orderWithComplateStatus = new Order();
        orderWithComplateStatus.setOrderStatus(OrderStatus.complate);

        OrderService orderService = new OrderService();
        orderService.setOrderRepository(orderRepository);
        orderService.setConnectMockPaymentService(connectMockPaymentService);

        when(connectMockPaymentService.getIsPaidFromMockAPI(0L)).thenReturn(true);
        when(orderRepository.findById(0L)).thenReturn(Optional.of(order));
        when(orderRepository.save(orderWithComplateStatus)).thenReturn(orderWithComplateStatus);

        Order result = orderService.CheckIsPaid(0L);
        assertEquals(result.getOrderStatus(), OrderStatus.complate);

    }

    @Test
    void Checkout() {
        Basket basketWithProducts = new Basket();
        Product product = new Product();
        List<Product> products = new ArrayList<>();
        products.add(product);

        basketWithProducts.setProducts(List.of(product));

        Basket basket = new Basket();

        Order orderWithProducts = new Order();
        orderWithProducts.setProducts(products);
        orderWithProducts.setOrderStatus(OrderStatus.pedding);

        when(basketRepository.findByUserId(0L)).thenReturn(Optional.of(basketWithProducts));
        when(basketService.CleanBasket(0L)).thenReturn(basket);
        when(orderRepository.save(orderWithProducts)).thenReturn(orderWithProducts);

        OrderService orderService = new OrderService();
        orderService.setOrderRepository(orderRepository);
        orderService.setAddressRepository(addressRepository);
        orderService.setBasketRepository(basketRepository);
        orderService.setBasketService(basketService);

        Order result = orderService.Checkout(0L);
        assertEquals(result.getProducts().size(), 1);

    }

}
