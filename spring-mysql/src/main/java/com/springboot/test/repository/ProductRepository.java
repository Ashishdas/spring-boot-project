package com.springboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.test.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}
