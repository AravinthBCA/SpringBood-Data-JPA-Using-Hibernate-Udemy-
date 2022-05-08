package com.spring.boot.data.MangoDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.boot.data.MangoDemo.Entities.Product;
import com.spring.boot.data.MangoDemo.Repos.ProductRepository;

@SpringBootTest
class MangoDemoApplicationTests {

	@Autowired
	ProductRepository productRepo;
	
//	@Test
	void testSave() {
		Product product = new Product();
		product.setName("Apple");
		product.setDescription("super");
		product.setPrice(2000);
		productRepo.save(product);
	}
	
//	@Test
	public void testFindAll() {
		List<Product> products = productRepo.findAll();
		assertEquals(1,products.size());
	}
	
//	@Test
	public void testDelete() {
		productRepo.deleteById("62725d3254309939e52b27bc");
		Optional<Product> product = productRepo.findById("62725d3254309939e52b27bc");
		assertEquals(Optional.empty(),product);
	}
	
	@Test
	public void testUpdate() {
		Product product = productRepo.findById("62725e5f5079cf2717c26662").get();
		product.setDescription("Good");
		productRepo.save(product);
	}

}
