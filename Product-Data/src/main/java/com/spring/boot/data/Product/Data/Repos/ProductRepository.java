package com.spring.boot.data.Product.Data.Repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.spring.boot.data.Product.Data.Entities.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
	
	List<Product> findByName(String name);
	
	List<Product> findByNameAndDesc(String name,String desc);
	
	List<Product> findByNameOrDesc(String name,String desc);
	
	List<Product> findByPriceGreaterThan(Double price);
	
	List<Product> findByDescContains(String desc);
	
	List<Product> findByPriceBetween(Double price1,Double price2);
	
	List<Product> findByDescLike(String desc);

	List<Product> findByIdIn(List<Integer> ids);
	
	List<Product> findByIdInPage(List<Integer> ids,Pageable pageable);

}
