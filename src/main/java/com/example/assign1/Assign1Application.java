package com.example.assign1;

import com.example.assign1.Basket.Basket;
import com.example.assign1.Basket.BasketRepository;
import com.example.assign1.Product.Product;
import com.example.assign1.Product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class Assign1Application {

	public static void main(String[] args) {
		SpringApplication.run(Assign1Application.class, args);
	}
	@Profile("!test")
	@Bean
	CommandLineRunner init (ProductRepository productRepository , BasketRepository basketRepository){
		return args -> {
			Product p1 = new Product();
			p1.setProductName("product1");
			Product p2 = new Product();
			p2.setProductName("product2");

			productRepository.save(p1);
			productRepository.save(p2);

			Basket basket = new Basket();
			basket.setUserId(0L);

			basketRepository.save(basket);
		};
	}

}
