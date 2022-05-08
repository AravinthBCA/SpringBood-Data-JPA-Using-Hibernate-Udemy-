package com.spring.boot.data.MangoDemo.Repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.boot.data.MangoDemo.Entities.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
