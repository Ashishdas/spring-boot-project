package com.springboot.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.test.dto.OrderResponse;
import com.springboot.test.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	// @Query("SELECT new com.springboot.test.dto.OrderResponse(c.name,p.name) from
	// Customer c Join c.products p")
	@Query(value = "select c.name,p.name from CUSTOMER_TBL.c join PRODUCT_TBL.p", nativeQuery = true)
	public List<OrderResponse> findJoinInformation();
}
