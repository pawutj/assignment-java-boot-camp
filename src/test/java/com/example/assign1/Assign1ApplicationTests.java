package com.example.assign1;

import com.example.assign1.Basket.*;
import com.example.assign1.Product.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Assign1ApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductController productController;

	@Autowired
	private ProductService productService;

	@Autowired
	private BasketRepository basketRepository;

	@Autowired
	private BasketService basketService;

	@Autowired
	private BasketController basketController;

	@Test
	void contextLoads() {
	}

	@Test
	void flowTest_FindProductAndChosenProduct(){

		Product p1 = new Product();
		p1.setProductName("product1");
		p1.setPrice(20);
		Product p2 = new Product();
		p2.setProductName("product2");

		productRepository.save(p1);
		productRepository.save(p2);

		productService.setProductRepository(productRepository);
		productController.setProductService(productService);

		ProductsResponse products =  testRestTemplate.getForObject("/product/findProductsByName/product",ProductsResponse.class);
		assertEquals(products.getProducts().size(),2);

		Long productChosenId = products.getProducts().get(0).getId();
		ProductResponse productChosen = testRestTemplate.getForObject("/product/findProductById/"+productChosenId,ProductResponse.class);
		assertEquals(productChosen.getProduct().getProductName(),"product1");
		assertEquals(productChosen.getProduct().getPrice(),20);

	}
	@Test
	void flowTest_AddProductToBasketAndShowBasket(){
		Product p1 = new Product();
		p1.setProductName("product1");
		p1.setPrice(20);

		Basket basket = new Basket();
		basket.setUserId(0L);



		Product product1 = productRepository.save(p1);
		Long product1Id = product1.getId();
		basketRepository.save(basket);

		productService.setProductRepository(productRepository);
		productController.setProductService(productService);
		basketService.setBasketRepository(basketRepository);
		basketService.setProductRepository(productRepository);
		basketController.setBasketService(basketService);


		BasketResponse result_1 = testRestTemplate.postForObject("/basket/addProductToBasketByUserId/0",product1Id,BasketResponse.class);
		assertEquals(result_1.getBasket().getProducts().size(),1);
		assertEquals(result_1.getBasket().getProducts().get(0).getProductName(),"product1");

		BasketResponse result_2 = testRestTemplate.getForObject("/basket/findBasketByUserId/0",BasketResponse.class);
		assertEquals(result_2.getBasket().getProducts().size(),1);
		assertEquals(result_2.getBasket().getProducts().get(0).getProductName(),"product1");
	}


}
