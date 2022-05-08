package com.spring.boot.data.Product.Data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order.Direction;
import com.spring.boot.data.Product.Data.Entities.Product;
import com.spring.boot.data.Product.Data.Repos.ProductRepository;


@SpringBootTest
class ProductDataApplicationTests {

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	EntityManager entityManager;

//	@Test
//	void contextLoads() {
//
//	}

	// testcase methods run randomly so validate db data properly
	// Ex: you write update and delete both are performing same id like id 5 means
	// the delete method
//remove the row then update method throw error

//	@Test
//	public void testCreate() {
//		Product product = new Product();
//		product.setName("IPhone");
//		product.setDesc("Awesome");
//		product.setPrice(20000D);
//		productRepo.save(product);
//		System.out.println("Inserted Successfull....");
//	}
//	
//	@Test
//	public void testRead() {
//		Product product = productRepo.findById(2).get();
//		assertNotNull(product);
//		assertEquals("IPhone",product.getName());
//		System.out.println("Product Get Successfull....");
//	}
//
//	@Test
//	public void testUpdate() {
//		Product product = productRepo.findById(6).get();
//		product.setPrice(1000D);
//		productRepo.save(product);
//		System.out.println("Update Successfull....");
//	}
//	
//	@Test
//	public void testDelete() {
//		if(productRepo.existsById(5)) {
//			productRepo.deleteById(5);
//		}
//		System.out.println("Delete Successfull....");
//	}
//	
//	@Test
//	public void testCount() {
//		System.out.println("Total Records : "+productRepo.count());
//	}
//	
//	@Test
//	public void testFindByName() {
//		List<Product> products = productRepo.findByName("IPhone");
//		products.forEach(p -> System.out.println(p.getPrice()));
//	}
//	
//	@Test
//	public void testFindByNameAndDesc() {
//		List<Product> products = productRepo.findByNameOrDesc("IPhone","Awesome");
//		products.forEach(p -> System.out.println(p.getPrice()));
//	}
//	
//	@Test
//	public void testFindByPriceGreaterThan() {
//		List<Product> products = productRepo.findByPriceGreaterThan(400D);
//		products.forEach(p -> System.out.println(p.getName()));
//	}
//	
//	@Test
//	public void testFindByDescContains() {
//		List<Product> products = productRepo.findByDescContains("Awesome");
//		products.forEach(p -> System.out.println(p.getName()));
//	}
//	
//	@Test
//	public void testFindByPriceBetween() {
//		List<Product> products = productRepo.findByPriceBetween(100D,500D);
//		products.forEach(p -> System.out.println(p.getName()));
//	}
//	
//	@Test
//	public void testFindByDescLike() {
//		List<Product> products = productRepo.findByDescLike("%we%");
//		products.forEach(p -> System.out.println(p.getName()));
//	}

//	@Test
//	public void testFindByIdsIn() {
//		List<Product> products = productRepo.findByIdIn(Arrays.asList(1,2,3));
//		products.forEach(p -> System.out.println(p.getName()));
//	}
//	
//	@Test
//	public void testFindAllPaging() {
//		Pageable pageable = PageRequest.of(0, 2);// page start with 0 and 1 for how many records
//		Page<Product> results = productRepo.findAll(pageable);
//		results.forEach(g -> System.out.println(g.getName()));
//	}

//	@Test
//	public void testFindAllSorting() {
//		productRepo.findAll(Sort.by(Sort.Direction.DESC, "name","price"))
//				.forEach(p -> System.out.println(p.getName()));
//above two lines using sort descing both name and price
//below two lines using different sorting for both
//		productRepo.findAll(Sort.by("name").descending().and(Sort.by("price")))
//				.forEach(p -> System.out.println(p.getName()));

//		productRepo.findAll(Sort.by("name"))
//		.forEach(p -> System.out.println(p.getName()));
//	}
	
//	@Test
//	public void testFindAllPagingAndSorting() {
//		Pageable pageable = PageRequest.of(0, 2,Sort.by("name").descending());
//		productRepo.findAll(pageable).forEach(p -> System.out.println(p.getName()));
//	}
	
//	@Test
//	public void testFindByIdsInPage() {
//		Pageable page = PageRequest.of(1,2);
//		List<Product> products = productRepo.findByIdInPage(Arrays.asList(1,2,3),page);
//		products.forEach(p -> System.out.println(p.getName()));
//	}
//	
//	@Test
//	@Transactional
//	@Cacheable("product-cache")
//	public void testCaching() {
//		Session session = entityManager.unwrap(Session.class);
//		Product product = productRepo.findById(4).get();
//		productRepo.findById(4).get();
//		
//		session.evict(product);
//		
//		productRepo.findById(4).get();
//	}
	
}
