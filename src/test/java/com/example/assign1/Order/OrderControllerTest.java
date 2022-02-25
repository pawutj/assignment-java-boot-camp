package com.example.assign1.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import com.example.assign1.Order.Address.Address;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import com.example.assign1.Product.Product;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private OrderService orderService;

    @Test
    void setAddressById() {

        Order order = new Order();
        Address address = new Address();

        address.setName("test");
        order.setAddress(address);

        when(orderService.setAddressById(address, 0L)).thenReturn(order);

        OrderResponse result = testRestTemplate.postForObject("/order/setAddressById/0", address, OrderResponse.class);
        assertEquals(result.getOrder().getAddress().getName(), "test");
    }

    void Checkout() {

        Order order = new Order();
        Product product = new Product();

        order.setProducts(List.of(product));

        when(orderService.Checkout(0L)).thenReturn(order);

        OrderResponse result = testRestTemplate.getForObject("/order/checkout/0", OrderResponse.class);
        assertEquals(result.getOrder().getProducts().size(), 1);

    }
}
