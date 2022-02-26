package com.example.assign1;

import com.example.assign1.Product.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Assign1ApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductController productController;

	@Autowired
	private ProductService productService;

	@Test
	void contextLoads() {
	}

	@Test
	void realWorldTest(){

//		Product p1 = new Product();
//		p1.setProductName("product1");
//		Product p2 = new Product();
//		p2.setProductName("product2");
//
//		productRepository.save(p1);
//		productRepository.save(p2);
//
//		productService.setProductRepository(productRepository);
//		productController.setProductService(productService);
//
//		ProductResponse product = productController.findProductsByName();


	}


}
