package com.springboot.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.test.model.Product;
import com.springboot.test.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}

	public List<Product> getProducts() {
		return repository.findAll();
	}

	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}

	public Product getProductByName(String name) {
		return repository.findByName(name);
	}

	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "product removed !! " + id;
	}

	public String updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);
		if (existingProduct != null) {
			existingProduct.setName(product.getName());
			existingProduct.setQuantity(product.getQuantity());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setModifiedBy(product.getModifiedBy());
			repository.save(existingProduct);
		} else {
			throw new NullPointerException("id not exist");
		}
		return "product updated successfully";
	}

}