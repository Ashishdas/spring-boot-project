package com.springboot.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.test.dto.OrderRequest;
import com.springboot.test.dto.OrderResponse;
import com.springboot.test.model.Customer;
import com.springboot.test.repository.CustomerRepository;
import com.springboot.test.repository.ProductRepository;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	//hii how are you
	@PostMapping("/placeOrder")
	public Customer placeOrder(@RequestBody OrderRequest orderRequest) {
		return customerRepository.save(orderRequest.getCustomer());
	}

	@GetMapping("/orderDetails")
	public List<Customer> findAllOrderDetails() {
		return customerRepository.findAll();
	}

	@GetMapping("/getJoinInfo")
	public List<OrderResponse> findJoinInformation() {
		return customerRepository.findJoinInformation();
	}

}
